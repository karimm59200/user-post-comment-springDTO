package com.example.tpuserpostcommentlike.controller;

import com.example.tpuserpostcommentlike.dto.CommentDto;
import com.example.tpuserpostcommentlike.entity.Comment;
import com.example.tpuserpostcommentlike.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("created_comment_mapper")
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody Comment comment){
        return new ResponseEntity<CommentDto>(commentService.createComment(comment), HttpStatus.CREATED);
    }

    @GetMapping("get_comment_mapper/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(commentService.getCommentById(id), HttpStatus.OK);
    }

    @GetMapping("get_all_comment_mapper")
    public ResponseEntity<List<CommentDto>> getAllComment(){
        return new ResponseEntity<>(commentService.getAllComment(), HttpStatus.OK);
    }

    @PutMapping("update_comment_mapper")
    public ResponseEntity<?> updateComment(@Valid @RequestBody CommentDto commentDto){
        commentService.updateComment(commentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete_comment_mapper/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable("id") Integer id){
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
