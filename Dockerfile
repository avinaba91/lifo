FROM openjdk:8-jre-slim
WORKDIR /home
COPY /target/lifo-*-SNAPSHOT.jar lifo.jar
COPY /bin/script.sh script.sh
RUN chmod 777 script.sh
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=$DATABASE_HOST", "-jar", "spring-h2-demo.jar"]