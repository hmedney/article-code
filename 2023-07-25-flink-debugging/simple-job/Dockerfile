##############################################################################
# Versions and constants
##############################################################################
ARG FLINK_IMAGE_URL=flink:1.17.1
ARG MAVEN_IMAGE=maven:3.8-jdk-11

##############################################################################
# Build job jar
##############################################################################
FROM ${MAVEN_IMAGE} AS build
WORKDIR /usr/app

# download dependencies in separate stage for caching (enables quicker builds when just changing /src)
COPY ./java/pom.xml .
RUN mvn dependency:resolve
RUN mvn dependency:resolve-plugins

# copy source and build
COPY ./java/src src/
RUN mvn package
RUN ls -la /usr/app/target

##############################################################################
# Final image
##############################################################################
FROM ${FLINK_IMAGE_URL}
ARG BUILD_JAR_NAME=example-job-1.0-SNAPSHOT-jar-with-dependencies.jar
ARG DEPLOY_JAR_NAME=example-job.jar

# add job jar to jobs dir
COPY --from=build /usr/app/target/${BUILD_JAR_NAME} ${FLINK_HOME}/jobs/${DEPLOY_JAR_NAME}

# package defailt 
COPY flink-conf/log4j-cli.properties /opt/flink/conf/