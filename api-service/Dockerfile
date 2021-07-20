FROM openjdk:11-jdk
COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY ./start.sh start.sh
# ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["sh", "start.sh"]