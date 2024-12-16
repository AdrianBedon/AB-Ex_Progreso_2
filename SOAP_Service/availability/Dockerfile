FROM maven:latest AS build
COPY . .
RUN mvn package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/availability-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "demo.jar"]