FROM maven:latest AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/room-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "demo.jar"]