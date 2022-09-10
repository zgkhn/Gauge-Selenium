FROM ubuntu

###

###
RUN apt-get update && apt-get install -q -y \
    curl \
    zip \
    openjdk-11-jdk \
    apt-transport-https \
    gnupg2 \
    ca-certificates

RUN curl -SsL https://downloads.gauge.org/stable | sh

RUN gauge install java 0.9.1 && \
    gauge install screenshot && \
    gauge install html-report && \
    gauge install json-report && \
    gauge install spectacle && \
    gauge install xml-report
# Install maven
RUN apt-get update \
 && DEBIAN_FRONTEND=noninteractive \
    apt-get install -y maven 3.8.6 \
 && apt-get clean \
 && rm -rf /var/lib/apt/lists/*

ENV PATH=$HOME/.gauge:$PATH

RUN apt-get update
RUN apt install -y git

RUN git init
RUN git clone https://github.com/zgkhn/Gauge-Selenium.git
#############java##################


###############################
##############################