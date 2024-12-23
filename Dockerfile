FROM eclipse-temurin:21-jre
WORKDIR /opt/app
COPY japp.jar .
EXPOSE 8080
CMD ["java", "-jar", "japp.jar"]