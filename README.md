# IMPORTANTE ....
tener descargado la dll mssql-jdbc_auth-9.2.1.x64.dll desde 
https://learn.microsoft.com/en-us/sql/connect/jdbc/release-notes-for-the-jdbc-driver?view=sql-server-ver16
https://go.microsoft.com/fwlink/?linkid=2155948

copiar la dll en 
C:\Windows\System32 
y en 
C:\Program Files\Java\jdk-22\bin


# My Gradle SQL Server Project

This project demonstrates how to connect to a SQL Server database using Java and Gradle, and execute a simple query.

## Configuration

Update the `src/main/resources/application.properties` file with your database connection details.

## probar

abrir con  IntelliJ IDEA 2024.1.2 (Community Edition) pararce en App.java y dale Play
ir a 
http://localhost:8081/DameFechaHora

## Compilar 


## sh
gradlew.bat clean

gradlew.bat build

java -jar build/libs/SistemaAnneDecor2-0.0.1-SNAPSHOT.jar

http://localhost:8085/TipoTela

## Docker Deploy 

docker build -t "java-sql-server" .


docker run -d -i -p 8085:8085 --name java-sql-server1 java-sql-server


## google cloud 
Para obtener el archivo JSON de la clave de servicio de tu proyecto de Google Cloud, sigue estos pasos:

Abre la Consola de Google Cloud.
En el menú de la izquierda, haz clic en "IAM y administración" y luego en "Cuentas de servicio".
Busca la cuenta de servicio que quieres utilizar o crea una nueva haciendo clic en "Crear cuenta de servicio".
Selecciona la cuenta de servicio y haz clic en "Administrar claves".
Haz clic en "Agregar clave", selecciona "Crear nueva clave" y elige el tipo de clave JSON.
Se descargará un archivo JSON con la clave de servicio. Guarda este archivo en un lugar seguro en tu sistema.


https://www.youtube.com/watch?v=7CvD6oHmYxU

para logearnos en google cloud 
docker login -u _json_key --password-stdin https://gcr.io < java-fede-638a8a7936ab.json
Login Succeeded


docker buildx build -t sql-server-images  --plataform linux/amd64 . 

docker tag sql-server-images gcr.io/proyect-id/sql-server-images:latest

docker push gcr.io/proyect-id/sql-server-images:latest

 ---- otra 
 
docker tag mcr.microsoft.com/mssql/server:2019-latest gcr.io/java-fede/mssql-server:2019-latest

docker push gcr.io/java-fede/mssql-server:2019-latest





