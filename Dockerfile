FROM openjdk:11
COPY ./target/hrms-api-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/app.jar", "--server.port=8001"]