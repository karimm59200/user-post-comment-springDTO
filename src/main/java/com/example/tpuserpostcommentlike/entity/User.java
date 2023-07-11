package com.example.tpuserpostcommentlike.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3, max = 15)
    private String username;

//    @NotNull
//    @Size(max = 8)
//    @Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]{2})(?=.*?[#?!@$%^&*-]).{5,8}$")
    private String password;

    @OneToMany (mappedBy = "user", cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
//    @JsonIgnore
    private List<Post> posts;
}
