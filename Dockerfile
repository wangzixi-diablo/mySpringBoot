FROM openjdk:8-jdk-alpine
VOLUME /tmp
VOLUME /log
EXPOSE 8080
ADD target/prolikeService.jar app.jar
ENV JAVA_OPTS="-Dserver.port=8080"
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar