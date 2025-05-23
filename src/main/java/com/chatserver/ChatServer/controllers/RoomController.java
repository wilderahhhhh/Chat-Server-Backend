package com.chatserver.ChatServer.controllers;

import com.chatserver.ChatServer.models.RoomModel;
import com.chatserver.ChatServer.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomModel> createRoom(@RequestBody RoomModel room) {
        RoomModel createdRoom = roomService.createRoom(room);
        return ResponseEntity.ok(createdRoom);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomModel> getRoom(@PathVariable UUID roomId) {
        return roomService.getRoomById(roomId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{roomId}/join/{userId}")
    public ResponseEntity<RoomModel> joinRoom(
            @PathVariable UUID roomId,
            @PathVariable UUID userId) {

        return roomService.addUserToRoom(roomId, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RoomModel>> getRooms() {
        return ResponseEntity.ok(roomService.getRooms());
    }
}
