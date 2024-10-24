FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]