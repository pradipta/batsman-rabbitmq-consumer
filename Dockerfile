FROM openjdk:8
ADD target/batsman.jar batsman.jar
#EXPOSE 8181
#EXPOSE 8181
ENTRYPOINT ["java", "-jar", "batsman.jar"]