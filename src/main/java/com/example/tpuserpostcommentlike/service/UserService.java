package com.example.tpuserpostcommentlike.service;


import com.example.tpuserpostcommentlike.Mapping.UserMapping;
import com.example.tpuserpostcommentlike.dto.UserDto;
import com.example.tpuserpostcommentlike.entity.User;
import com.example.tpuserpostcommentlike.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapping userMapping;

    public UserDto createUser(User user){
        User userCreated = userRepository.save(user);
        return userMapping.convertToDto(userCreated);
    }

    public UserDto getUserById(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(user -> userMapping.convertToDto(user)).orElse(null);
    }

    public List<UserDto> getAllUser(){
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().map(user -> userMapping.convertToDto(user)).collect(Collectors.toList());
    }

    public void updateUser(UserDto dto){
        userRepository.save(userMapping.convertToEntity(dto));
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }


}
