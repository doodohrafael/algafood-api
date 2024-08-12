FROM openjdk:17-slim

WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE} /app/algafood-api.jar

EXPOSE 8080

CMD ["java", "-jar", "algafood-api.jar"]