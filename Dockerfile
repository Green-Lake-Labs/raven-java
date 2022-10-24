FROM maven AS builder
COPY src src
COPY pom.xml pom.xml
RUN mvn package -DskipTests

FROM openjdk:11-jre
COPY --from=builder target/raven.jar raven.jar
ENTRYPOINT ["java", "-jar", "raven.jar"]