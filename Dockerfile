# Usa una imagen base de OpenJDK 20
FROM openjdk:20-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Instala curl, nano y ping
RUN apt-get update && apt-get install -y curl nano iputils-ping

# Copia el código fuente y los scripts Gradle al contenedor
COPY . .

# Da permisos de ejecución al wrapper de Gradle
RUN chmod +x gradlew

# Ejecuta los comandos Gradle para limpiar y construir el proyecto
RUN ./gradlew clean build

# Expone el puerto en el que la aplicación está usando (en tu caso, 8081)
EXPOSE 8085

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/SistemaAnneDecor2-0.0.1-SNAPSHOT.jar"]
