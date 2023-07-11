package com.example.tpuserpostcommentlike.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private Integer id;
    @NotNull
    @Size(max = 500)
    private String message;
    private Integer postId;
}
