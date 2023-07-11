package com.example.tpuserpostcommentlike.Mapping;

import com.example.tpuserpostcommentlike.dto.PostDto;
import com.example.tpuserpostcommentlike.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapping implements EntityDto<PostDto, Post>{
    @Override
    public PostDto convertToDto(Post entity) {
        PostDto dto = new PostDto();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setUser(entity.getUser());
        return dto;
    }

    @Override
    public Post convertToEntity(PostDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return post;
    }
}
