package com.example.tpuserpostcommentlike.controller;

import com.example.tpuserpostcommentlike.dto.UserDto;
import com.example.tpuserpostcommentlike.entity.User;
import com.example.tpuserpostcommentlike.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/")
public class UserControllerMapper {

    @Autowired
    private UserService userService;

   @PostMapping("created_user_mapper")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<UserDto>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("get_user_mapper/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("get_all_user_mapper")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PutMapping("update_user_mapper")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete_user_mapper/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
