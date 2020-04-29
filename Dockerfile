FROM maven:3.6.3-openjdk-15
WORKDIR app

COPY . .
RUN mvn package
RUN cp config.properties.default target/config.properties

FROM openjdk:15-alpine
WORKDIR app

COPY --from=0 /app/target/NurseBot-1.0-SNAPSHOT.jar .
COPY --from=0 /app/target/config.properties .
CMD ["java", "-jar", "NurseBot-1.0-SNAPSHOT.jar"]

