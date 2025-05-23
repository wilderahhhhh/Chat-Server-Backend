package com.chatserver.ChatServer.services;




import com.chatserver.ChatServer.models.RoomModel;
import com.chatserver.ChatServer.models.UserModel;
import com.chatserver.ChatServer.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserService userService;
    public ArrayList<RoomModel> getRooms(){
        return (ArrayList<RoomModel>) roomRepository.findAll();
    }
    public RoomModel createRoom(RoomModel room){
        return roomRepository.save(room);
    }

    public Optional<RoomModel> addUserToRoom(UUID roomId, UUID userId) {
        Optional<RoomModel> roomOpt = roomRepository.findById(roomId);
        Optional<UserModel> userOpt = userService.getUserById(userId);

        if (roomOpt.isPresent() && userOpt.isPresent()) {
            RoomModel room = roomOpt.get();
            UserModel user = userOpt.get();

            if (!room.getMembers().contains(user)) {
                room.getMembers().add(user);
                return Optional.of(roomRepository.save(room));
            }
            return roomOpt;
        }
        return Optional.empty();
    }


    public Optional<RoomModel> getRoomById(UUID id){
        return roomRepository.findById(id);
    }

    public Boolean deleteRoomById(UUID  id){
        try {
            roomRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }

}
