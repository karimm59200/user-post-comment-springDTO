package com.example.tpuserpostcommentlike.controller;


import com.example.tpuserpostcommentlike.dto.LikeDto;
import com.example.tpuserpostcommentlike.entity.Liked;
import com.example.tpuserpostcommentlike.service.LikeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class LikeController {

   @Autowired
    private LikeService likeService;

   @PostMapping("created_like_mapper")
    public ResponseEntity<LikeDto> createLike(@Valid @RequestBody LikeDto liked){
        return new ResponseEntity<LikeDto>(likeService.createLike(liked), HttpStatus.CREATED);
    }

    @GetMapping ("get_like_mapper/{id}")
    public ResponseEntity<LikeDto> getLikeById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(likeService.getLikeById(id), HttpStatus.OK);
    }

    @GetMapping("get_all_like_mapper")
    public ResponseEntity<List<LikeDto>> getAllLike(){
        return new ResponseEntity<>(likeService.getAllLike(), HttpStatus.OK);
    }

    @PutMapping("update_like_mapper")
    public ResponseEntity<?> updateLike(@Valid @RequestBody LikeDto likeDto){
        likeService.updateLike(likeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete_like_mapper/{id}")
    public ResponseEntity<?> deleteLike(@PathVariable("id") Integer id){
        likeService.deleteLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
