FROM openjdk:17
WORKDIR /app
COPY target/eureka-server-1.0-SNAPSHOT.jar eureka-server-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureka-server-1.0-SNAPSHOT.jar"]
EXPOSE 8761