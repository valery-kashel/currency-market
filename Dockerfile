FROM openjdk:17-slim

RUN mkdir /app
WORKDIR /app
COPY ./*.jar /app/service.jar

RUN ls -la

EXPOSE 8080

CMD ["java", "-jar", "/app/service.jar"]