FROM openjdk:11
EXPOSE 8082
ADD target/m2-docker.jar m2-docker.jar
ENTRYPOINT ["java", "-jar", "/m2-docker.jar"]