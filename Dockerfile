FROM openjdk:8-alpine
ADD target/config-server-0.2.3.jar config-server.jar

# Set default timezone
ENV TZ=Europe/Moscow

ENTRYPOINT ["java", "-jar", "config-server.jar"]