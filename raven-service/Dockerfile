FROM openjdk11-maven AS builder
COPY src src
COPY pom.xml pom.xml
RUN mvn package

FROM openjdk11
COPY --from=builder target/raven.jar raven.jar
ENTRYPOINT ["java", "-jar", "raven.jar"]