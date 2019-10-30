# This file is used to build and run the Spring boot application
# It uses multi-stage builds which is introduced since docker 17.05 (multiple 'FROM' instructions)
# So, this file needs to be used with docker 17.05+

#Use the maven base image for the container in which to build the Spring Boot app
FROM maven:3.6.2-jdk-8 AS java_mysql_app_builder

# Create the directory inside which to build the Spring Boot application
RUN mkdir -p /build_app

WORKDIR /build_app/

# Copy the pom.xml and the application source code to the build_app directory
COPY pom.xml /build_app
COPY src /build_app/src

# Build the application on the java_mysql_app_builder docker container
RUN mvn clean package

# Use the openjdk:8-jre-alpine lightweight image to run the Spring boot application.
# We do not need to get a bigger image with JDK, we only need JRE for running the application.
FROM openjdk:8-jre-alpine

WORKDIR /app

# Get the jar file of the application built on the java_mysql_app_builder image
COPY --from=java_mysql_app_builder /build_app/target/topcoder-api-java-mysql-1.0.0.jar /app/

# Run the application
ENTRYPOINT ["java", "-jar", "topcoder-api-java-mysql-1.0.0.jar"]