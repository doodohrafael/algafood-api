FROM openjdk:17-slim

WORKDIR /app

ARG JAR_FILE

# Cria diretório temporário com permissões
RUN mkdir -p /tmp/algafood && chmod -R 777 /tmp/algafood

COPY target/${JAR_FILE} /app/algafood-api.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

# Define variáveis de ambiente para o diretório temporário
ENV JAVA_TMPDIR=/tmp/algafood
ENV CATALINA_TMPDIR=/tmp/algafood/tomcat

EXPOSE 8080

#CMD ["java", "-jar", "algafood-api.jar"]
CMD ["java", "-Djava.io.tmpdir=/tmp/algafood", "-Dserver.tomcat.basedir=/tmp/algafood/tomcat", "-jar", "algafood-api.jar"]