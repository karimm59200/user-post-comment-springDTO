package com.example.tpuserpostcommentlike.Mapping;

import com.example.tpuserpostcommentlike.dto.LikeDto;
import com.example.tpuserpostcommentlike.entity.Liked;
import org.springframework.stereotype.Component;

@Component
public class LikeMapping implements EntityDto<LikeDto, Liked> {
    @Override
    public LikeDto convertToDto(Liked entity) {
        LikeDto dto = new LikeDto();
        dto.setId(entity.getId());
        dto.setLiked(entity.isLiked());
        dto.setCommentId(entity.getComment().getId());
        return dto;
    }

    @Override
    public Liked convertToEntity(LikeDto dto) {
        Liked like = new Liked();
        like.setId(dto.getId());
        like.setLiked(dto.isLiked());
        return like;
    }
}
