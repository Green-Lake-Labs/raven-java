FROM maven AS builder
COPY src src
COPY pom.xml pom.xml
RUN mvn package -Dspring.profiles.active=docker

FROM openjdk:11-oracle
COPY --from=builder target/raven.jar raven.jar
ENTRYPOINT ["java", "-jar", "raven.jar"]