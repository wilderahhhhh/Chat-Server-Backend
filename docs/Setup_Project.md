# Set up Project


# Database 
*  **Instalación de Docker Desktop**
* **Descarga la ultima imagen de Mysql**
> docker pull mysql:latest

* **Crear un contenedor**
> docker run -d --name dbChatMySQL -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=chat -p 3306:3306 mysql:latest

## Para acceder a la base de datos

para ver los contenedores
> docker ps

acceder al contenedor

> docker exec -it dbChatMySQL -u root -p

