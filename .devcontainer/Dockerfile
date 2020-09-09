# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.134.1/containers/ubuntu/.devcontainer/base.Dockerfile
ARG VARIANT="focal"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-${VARIANT}

# [Optional] Uncomment this section to install additional OS packages.
RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get update \ 
    && apt-get -y install --no-install-recommends \
        software-properties-common \
        fontconfig \
        unzip \
        wget \
        git \
    && apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/* /tmp/library-scripts

RUN wget -O- https://apt.corretto.aws/corretto.key | apt-key add - \
    && add-apt-repository 'deb https://apt.corretto.aws stable main'

RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get update \ 
    && apt-get -y install --no-install-recommends \
        java-11-amazon-corretto-jdk \
    && apt-get autoremove -y \
    && apt-get clean -y \
    && rm -rf /var/lib/apt/lists/* /tmp/library-scripts

ENV GRADLE_VERSION 6.6.1
ARG GRADLE_DOWNLOAD_SHA256=7873ed5287f47ca03549ab8dcb6dc877ac7f0e3d7b1eb12685161d10080910ac
ENV GRADLE_HOME /opt/gradle
RUN set -o errexit -o nounset \
    && echo "Downloading Gradle" \
    && wget --no-verbose --output-document=gradle.zip "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" \
    && echo "Checking download hash" \
    && echo "${GRADLE_DOWNLOAD_SHA256} *gradle.zip" | sha256sum --check - \
    && echo "Installing Gradle" \
    && unzip gradle.zip \
    && rm gradle.zip \
    && mv "gradle-${GRADLE_VERSION}" "${GRADLE_HOME}/" \
    && ln --symbolic "${GRADLE_HOME}/bin/gradle" /usr/bin/gradle \
    && echo "Testing Gradle installation" \
    && gradle --version

# RUN git clone https://github.com/spring-guides/gs-spring-boot-docker.git gs-spring-boot-docker \
#     && cd gs-spring-boot-docker/initial \
#     && ./gradlew build

# RUN cp gs-spring-boot-docker/initial/build/libs/gs-spring-boot-docker-0.1.0.jar /app.jar

# WORKDIR / 
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","/app.jar"]