FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-devops-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ms-devops-0.0.1-SNAPSHOT.jar"]