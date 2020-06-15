FROM maven:3.5.4-jdk-8-alpine as maven
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn dependency:go-offline -B
RUN mvn package
FROM openjdk:8u171-jre-alpine
WORKDIR /demo
COPY InfyBuddy.jar ./demo/InfyBuddy.jar
COPY --from=maven target/*.jar ./demo/review.jar
EXPOSE 8080
ENTRYPOINT ["java","-javaagent:./demo/InfyBuddy.jar","-jar","./demo/review.jar"]
