FROM openjdk:17
WORKDIR /app
COPY target/customer-1.0-SNAPSHOT.jar customer-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","customer-1.0-SNAPSHOT.jar"]
EXPOSE 8081
#FROM openjdk:17
#WORKDIR /app
#COPY target/customer-1.0-SNAPSHOT.jar /app/customer-1.0-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/app/customer-1.0-SNAPSHOT.jar"]
#EXPOSE 8081
