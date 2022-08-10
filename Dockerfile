FROM maven:3.6.3-openjdk-11-slim
EXPOSE 8080
WORKDIR /app

COPY pom.xml .
COPY ./src ./src
COPY ./pom.xml ./pom.xml
COPY ./api-contract ./api-contract

RUN mvn package

ENTRYPOINT ["java","-jar","target/SimpleApp-1.0-SNAPSHOT.jar"]