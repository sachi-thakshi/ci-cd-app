# Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# working directory inside container
WORKDIR /app

# save .jar inside the Docker Image
COPY target/*.jar app.jar

# for run container want this
EXPOSE 8080

# java -jar filename.jar
ENTRYPOINT ["java", "-jar", "app.jar"]