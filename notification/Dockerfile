FROM openjdk:17
WORKDIR /app
ADD target/notification-1.0-SNAPSHOT.jar notification-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","notification-1.0-SNAPSHOT.jar"]
EXPOSE 8083
#FROM openjdk:17
#WORKDIR /app
#COPY target/notification-1.0-SNAPSHOT.jar /app/notification-1.0-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/app/notification-1.0-SNAPSHOT.jar"]
#EXPOSE 8083