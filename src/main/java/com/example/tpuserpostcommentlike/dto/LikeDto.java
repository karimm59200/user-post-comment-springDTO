package com.example.tpuserpostcommentlike.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LikeDto {
    private Integer id;
    private boolean liked;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Integer commentId;
}
