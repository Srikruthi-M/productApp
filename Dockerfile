FROM maven:3.9.4-eclipse-temurin-17-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -X package -DskipTests


FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app


COPY --from=build /app/target/*.jar productservice.jar


EXPOSE 8200


ENTRYPOINT ["java", "-jar", "productservice.jar"]
