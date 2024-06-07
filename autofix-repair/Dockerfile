FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} autofix-repair.jar
ENTRYPOINT ["java", "-jar", "/autofix-repair.jar"]