package com.chatserver.ChatServer.services;

import com.chatserver.ChatServer.models.UserModel;
import com.chatserver.ChatServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(UUID id){
        return userRepository.findById(id);
    }
    public UserModel updateById(UserModel userRequest, UUID id){
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public Boolean deleteUserById(UUID  id){
        try {
            userRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }

}