FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /log
ADD target/prolikeService.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar