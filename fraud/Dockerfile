FROM openjdk:17
WORKDIR /app
COPY target/fraud-1.0-SNAPSHOT.jar fraud-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","fraud-1.0-SNAPSHOT.jar"]
EXPOSE 8082