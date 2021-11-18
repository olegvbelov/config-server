FROM openjdk:8-alpine
ADD target/config-server-*.jar config-server.jar
COPY UnlimitedJCEPolicyJDK8/* /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/

# Set default timezone
ENV TZ=Europe/Moscow

ENTRYPOINT ["java", "-jar", "config-server.jar"]