FROM amazoncorretto:21-al2023-jdk

WORKDIR /app

COPY target/hello-world-0.0.1-SNAPSHOT.jar /app/app.jar
COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]