# Chat Server

Backend para un sistema de chat en tiempo real desarrollado con Java y Spring Boot. El proyecto utiliza WebSockets y el protocolo STOMP para permitir la comunicación en tiempo real entre clientes conectados a diferentes salas de chat.

El servidor también proporciona una API REST para la gestión de usuarios y salas, utilizando Spring Data JPA y MySQL para la persistencia de los datos.

## Tecnologías

* Java 21
* Spring Boot 3.4.4
* Maven
* Spring Web
* Spring Data JPA
* Spring WebSocket
* STOMP
* SockJS
* MySQL
* Docker
* Lombok

## Funcionalidades

* Gestión de usuarios
* Creación y consulta de salas
* Unión de usuarios a salas
* Comunicación de mensajes en tiempo real
* Comunicación mediante WebSockets
* Protocolo STOMP
* Mensajes separados por sala
* Persistencia de usuarios y salas
* Creación y actualización automática de tablas mediante Hibernate

## Arquitectura

El proyecto está organizado siguiendo una separación por responsabilidades:

```text
src/main/java/com/chatserver/ChatServer/

├── config/
│   └── WebSocketConfig.java
│
├── controllers/
│   ├── MessageController.java
│   └── RoomController.java
│
├── models/
│   ├── MessageModel.java
│   ├── RoomModel.java
│   └── UserModel.java
│
├── repositories/
│   ├── RoomRepository.java
│   └── UserRepository.java
│
└── services/
    ├── RoomService.java
    └── UserService.java
```

### Comunicación WebSocket

El endpoint utilizado para establecer la conexión WebSocket es:

```text
/ws
```

Los mensajes enviados por los clientes utilizan el prefijo:

```text
/app
```

Para enviar un mensaje a una sala:

```text
/app/chat/{roomId}
```

Los clientes se suscriben al canal correspondiente a la sala:

```text
/topic/{roomId}
```

El flujo de comunicación es:

```text
Cliente
   │
   │ STOMP
   ▼
/app/chat/{roomId}
   │
   ▼
MessageController
   │
   ▼
/topic/{roomId}
   │
   ├── Cliente 1
   ├── Cliente 2
   └── Cliente 3
```

### API REST

#### Crear una sala

```http
POST /api/rooms
```

#### Obtener todas las salas

```http
GET /api/rooms
```

#### Obtener una sala

```http
GET /api/rooms/{roomId}
```

#### Agregar un usuario a una sala

```http
POST /api/rooms/{roomId}/join/{userId}
```

## Ejecución

Primero configura el contenedor de MySQL siguiendo:

[Setup Project](docs/Setup_Project.md)

Después ejecuta el servidor con Maven Wrapper:

### Windows

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

## Comandos Maven

Compilar el proyecto:

```cmd
mvnw.cmd compile
```

Ejecutar los tests:

```cmd
mvnw.cmd test
```

Crear el paquete de la aplicación:

```cmd
mvnw.cmd package
```

Limpiar y empaquetar:

```cmd
mvnw.cmd clean package
```

Ejecutar la aplicación:

```cmd
mvnw.cmd spring-boot:run
```

## Documentación

Diagramas del proyecto:

[Diagrams](docs/Diagrams.md)

Configuración y ejecución:

[Setup Project](docs/Setup_Project.md)
