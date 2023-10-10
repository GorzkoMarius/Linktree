package com.project.linked.services;

import com.project.linked.dto.DtoUser;
import com.project.linked.dto.Response;
import com.project.linked.models.UserModel;
import com.project.linked.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserModel> getAllUsers(){
        return this.userRepository.findAll();
    }

    public UserModel getUser(Long id){
        return this.userRepository.findById(id).orElseThrow();
    }
    @Transactional
    public Response<UserModel> insertUser(DtoUser user){
        Response<UserModel> response = new Response<>();
        UserModel userModel = new UserModel();
        userModel.setFields(user);
        response.setResponseBody(userRepository.save(userModel));
        return response;
    }
    @Transactional
    public Response<UserModel> updateUser(DtoUser user, Long id){
        Response<UserModel> response = new Response<>();
        UserModel userModel = userRepository.findById(id).orElseThrow();
        userModel.setFields(user);
        response.setResponseBody(userModel);
        return response;
    }

    @Transactional
    public String deleteUser(Long id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        return "User removed";
    }
}
