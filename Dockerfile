FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


# FROM ubuntu:latest

#define o responsável pela aplicação
#LABEL maintainer=”Thiago Marques”

#Atualiza o SO
#RUN apt-get update && apt-get upgrade -y

#Instala o python3, pip3 e o git
#RUN apt-get install python3 python3-pip git -y

#clona o APP
#RUN git clone https://github.com/thiagosagara/CRUD-FLASK-PYTHON.git /opt/CRUD-FLASK-PYTHON/

#vai para o diretório principal
#WORKDIR /opt/CRUD-FLASK-PYTHON/

#Instala o aplicativo
#RUN pip3 install -r requirements.txt
#RUN python3 -m flask db init && python3 -m flask db migrate && python3 -m flask db upgrade

#Expoe a porta 80 (apenas para documentação)
#EXPOSE 80

# Entra na pasta do app (só é executado quando iniciamos o container)
#CMD [“python3”, “wsgi.py”]