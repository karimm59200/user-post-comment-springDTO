package com.example.tpuserpostcommentlike.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
public class UserDto {
    private Integer id;
    @Column(unique = true)
    private String username;

}
