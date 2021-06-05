FROM openjdk:11.0-jdk-slim

EXPOSE 8082

VOLUME /tmp
COPY target/receiver-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]