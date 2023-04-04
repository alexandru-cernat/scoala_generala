FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-debian-slim
ARG JAR_FILE=target/*.jar
COPY ./target/scoala_generala-0.0.1-SNAPSHOT.jar /scoala_generala-0.0.1.jar
#COPY src/main/resources/DB /scoala_generala-0.0.1/src/main/resources
ENTRYPOINT ["java","-jar","/scoala_generala-0.0.1.jar"]