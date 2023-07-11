package com.example.tpuserpostcommentlike.dto;

import com.example.tpuserpostcommentlike.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

//    private Integer id;
    @NotNull
    @Size(min=4, max = 15)
    private String title;
    @Size(max = 250)
    private String content;
    private User user;


}
