package com.example.tpuserpostcommentlike.controller;


import com.example.tpuserpostcommentlike.dto.PostDto;
import com.example.tpuserpostcommentlike.entity.Post;
import com.example.tpuserpostcommentlike.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class PostControllerMapper {

    @Autowired
    private PostService postService;

    @PostMapping("created_post_mapper")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody Post post){
        return new ResponseEntity<PostDto>(postService.createPost(post), HttpStatus.CREATED);
    }

    @GetMapping("get_post_mapper/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("get_all_post_mapper")
    public ResponseEntity<Iterable<PostDto>> getAllPost(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @PutMapping("update_post_mapper")
    public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto){
        postService.updatePost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("delete_post_mapper/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Integer id){
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
