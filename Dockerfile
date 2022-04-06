FROM openjdk:8
COPY ./target/cafe-springboot-1.0-SNAPSHOT.jar /tmp
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","cafe-springboot-1.0-SNAPSHOT.jar"]