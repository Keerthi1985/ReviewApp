FROM openjdk:8-jdk-alpine
WORKDIR /demo
COPY InfyBuddy.jar ./demo/InfyBuddy.jar
COPY Reviewdemo-0.0.1-SNAPSHOT.jar ./demo/review.jar
EXPOSE 8080
ENTRYPOINT ["java","-javaagent:./demo/InfyBuddy.jar","-jar","./demo/review.jar"]
