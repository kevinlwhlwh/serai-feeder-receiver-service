FROM openjdk:11.0-jdk-slim

EXPOSE 8081

VOLUME /tmp
COPY target/feeder-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]