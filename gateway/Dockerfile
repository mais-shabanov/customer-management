FROM openjdk:17
WORKDIR /app
COPY target/gateway-1.0-SNAPSHOT.jar gateway-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","gateway-1.0-SNAPSHOT.jar"]
EXPOSE 8084