package com.chatserver.ChatServer.repositories;


import com.chatserver.ChatServer.models.RoomModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends CrudRepository<RoomModel, UUID> {

}