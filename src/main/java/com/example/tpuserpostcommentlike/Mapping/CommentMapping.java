package com.example.tpuserpostcommentlike.Mapping;

import com.example.tpuserpostcommentlike.dto.CommentDto;
import com.example.tpuserpostcommentlike.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapping implements EntityDto<CommentDto, Comment>{
    @Override
    public CommentDto convertToDto(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setMessage(entity.getMessage());
        dto.setPostId(entity.getPost().getId());
        return dto;
    }

    @Override
    public Comment convertToEntity(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setMessage(dto.getMessage());
        return comment;
    }
}
