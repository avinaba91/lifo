FROM openjdk:8-jre-slim
WORKDIR /home
COPY /target/lifo-*-SNAPSHOT.jar lifo.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=$DATABASE_HOST", "-jar", "spring-h2-demo.jar"]