# Configuración del proyecto

Esta guía explica cómo configurar MySQL mediante Docker y ejecutar el servidor Spring Boot.

## MySQL con Docker

### 1. Descargar la imagen de MySQL

Descargar la imagen de MySQL:

```cmd
docker pull mysql:latest
```

### 2. Crear el contenedor

Crear el contenedor de MySQL:

```cmd
docker run -d --name dbChatMySQL -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=chat -p 3306:3306 mysql:latest
```

La configuración utilizada por el proyecto es:

```text
Contenedor: dbChatMySQL
Base de datos: chat
Usuario: root
Contraseña: admin
Puerto: 3306
```

Hibernate se encarga de crear y actualizar las tablas correspondientes a las entidades del proyecto mediante:

```properties
spring.jpa.hibernate.ddl-auto=update
```

## Ejecutar el servidor

Una vez creado el contenedor de MySQL, ejecutar el proyecto desde la raíz:

```cmd
mvnw.cmd spring-boot:run
```

El servidor estará disponible en:

```text
http://localhost:7777
```

El endpoint de WebSocket es:

```text
http://localhost:7777/ws
```

## Comunicación WebSocket

El proyecto utiliza WebSockets con STOMP.

Endpoint de conexión:

```text
/ws
```

Destino para enviar mensajes:

```text
/app/chat/{roomId}
```

Destino para recibir mensajes:

```text
/topic/{roomId}
```

Ejemplo:

```text
Enviar:
/app/chat/550e8400-e29b-41d4-a716-446655440000
```

```text
Suscribirse:
/topic/550e8400-e29b-41d4-a716-446655440000
```
