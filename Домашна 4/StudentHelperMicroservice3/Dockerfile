FROM openjdk:11
EXPOSE 8083
ADD target/m3-docker.jar m3-docker.jar
ENTRYPOINT ["java", "-jar", "/m3-docker.jar"]