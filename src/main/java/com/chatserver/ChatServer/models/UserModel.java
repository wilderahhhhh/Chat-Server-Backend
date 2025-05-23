package com.chatserver.ChatServer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    public UserModel() {
        this.id = UUID.randomUUID();
    }

    public UserModel(UUID id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}