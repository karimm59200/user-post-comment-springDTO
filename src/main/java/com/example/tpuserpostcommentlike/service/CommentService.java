package com.example.tpuserpostcommentlike.service;

import com.example.tpuserpostcommentlike.Mapping.CommentMapping;
import com.example.tpuserpostcommentlike.dto.CommentDto;
import com.example.tpuserpostcommentlike.entity.Comment;
import com.example.tpuserpostcommentlike.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapping commentMapping;

    public CommentDto createComment(Comment comment){
        Comment commentCreated = commentRepository.save(comment);
        return commentMapping.convertToDto(commentCreated);
    }

    public CommentDto getCommentById(Integer id){
        return commentMapping.convertToDto(commentRepository.findById(id).orElse(null));
    }

    public List<CommentDto> getAllComment(){
        List<Comment> comments = (List<Comment>) commentRepository.findAll();
        return comments.stream().map(comment -> commentMapping.convertToDto(comment)).collect(Collectors.toList());
    }

    public void updateComment(CommentDto dto){
        commentRepository.save(commentMapping.convertToEntity(dto));
    }

    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
    }



}
