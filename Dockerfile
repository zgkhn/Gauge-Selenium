FROM ubuntu

# Install Java.
RUN apt-get update && apt-get install -q -y \
    curl \
    zip \
    openjdk-11-jdk \
    apt-transport-https \
    gnupg2 \
    ca-certificates

RUN curl -SsL https://downloads.gauge.org/stable | sh

# Install gauge plugins
RUN gauge install java && \
    gauge install screenshot

ENV PATH=$HOME/.gauge:$PATH

RUN git clone https://github.com/zgkhn/Gauge-Selenium.git

CMD ["mvn", "gauge:execute", "-DspecsDir=specs", "-DinParallel=true"]
