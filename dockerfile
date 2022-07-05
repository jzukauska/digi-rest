FROM maven:3.8-jdk-11

WORKDIR /opt/Maven

COPY src src
COPY pom.xml .

RUN mvn clean && mvn install

EXPOSE 8080
CMD [ "java","-jar", "target/digi-rest-0.0.1-SNAPSHOT.jar" ]