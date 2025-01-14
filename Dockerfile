FROM eclipse-temurin:21-jre
WORKDIR /opt/app
COPY japp.jar .
EXPOSE 8080
EXPOSE 5005
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "japp.jar"]