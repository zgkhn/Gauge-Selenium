FROM ubuntu

###
FROM browserless/base:1.14.0

# Build Args
ARG USE_CHROME_STABLE
ARG PUPPETEER_CHROMIUM_REVISION
ARG PUPPETEER_VERSION

# Application parameters and variables
ENV APP_DIR=/usr/src/app
ENV PLAYWRIGHT_BROWSERS_PATH=${APP_DIR}
ENV CONNECTION_TIMEOUT=60000
ENV CHROME_PATH=/usr/bin/google-chrome
ENV HOST=0.0.0.0
ENV IS_DOCKER=true
ENV LANG="C.UTF-8"
ENV NODE_ENV=production
ENV PORT=3000
ENV PUPPETEER_CHROMIUM_REVISION=${PUPPETEER_CHROMIUM_REVISION}
ENV PUPPETEER_SKIP_CHROMIUM_DOWNLOAD=true
ENV USE_CHROME_STABLE=${USE_CHROME_STABLE}
ENV WORKSPACE_DIR=$APP_DIR/workspace

RUN mkdir -p $APP_DIR $WORKSPACE_DIR

WORKDIR $APP_DIR

# Install app dependencies
COPY . .

# Install Chrome Stable when specified
RUN if [ "$USE_CHROME_STABLE" = "true" ]; then \
    cd /tmp &&\
    wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb &&\
    dpkg -i google-chrome-stable_current_amd64.deb;\
  fi

# Build and install external binaries + assets
# NOTE: The `PUPPETEER_VERSION` is needed for production versions
# listed in package.json
RUN if [ "$USE_CHROME_STABLE" = "true" ]; then \
    export CHROMEDRIVER_SKIP_DOWNLOAD=false;\
  else \
    export CHROMEDRIVER_SKIP_DOWNLOAD=true;\
  fi &&\
  npm ci && \
  npm i puppeteer@$PUPPETEER_VERSION;\
  npm run build &&\
  chown -R blessuser:blessuser $APP_DIR

# Run everything after as non-privileged user.
USER blessuser

# Expose the web-socket and HTTP ports
EXPOSE 3000

CMD ["./start.sh"]

###
RUN apt-get update && apt-get install -q -y \
    curl \
    zip \
    openjdk-18-jdk \
    apt-transport-https \
    gnupg2 \
    ca-certificates

RUN curl -SsL https://downloads.gauge.org/stable | sh

RUN gauge install java 1.4.3 && \
    gauge install screenshot && \
    gauge install html-report && \
    gauge install json-report

# Install maven
RUN apt-get update \
 && DEBIAN_FRONTEND=noninteractive \
    apt-get install -y maven 3.8.6 \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

ENV PATH=$HOME/.gauge:$PATH
RUN apt-get update
RUN apt install -y git
RUN mkdir proje
RUN cd proje
RUN git init
RUN git clone https://github.com/zgkhn/Gauge-Selenium.git
