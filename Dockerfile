FROM ubuntu:latest
LABEL authors="adptdkid"

FROM openjdk:17-jdk-alpine

COPY build/libs/springServer-0.0.1-SNAPSHOT.jar app-1.0.jar

ENTRYPOINT ["java", "-jar", "app-1.0.jar"]