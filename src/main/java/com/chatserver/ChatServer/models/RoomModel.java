package com.chatserver.ChatServer.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "room")
public class RoomModel {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String rooName;
    @ManyToMany
    private List<UserModel> members;

    public RoomModel() {
        this.id = UUID.randomUUID();
    }

    public RoomModel(UUID id, String rooName, List<UserModel> members) {
        this.id = id;
        this.rooName = rooName;
        this.members = members;
    }

    public UUID getId() {
        return id;
    }

    public String getRooName() {
        return rooName;
    }

    public void setRooName(String rooName) {
        this.rooName = rooName;
    }

    public List<UserModel> getMembers() {
        return members;
    }

    public void setMembers(List<UserModel> members) {
        this.members = members;
    }
}
