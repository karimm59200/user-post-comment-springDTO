package com.example.tpuserpostcommentlike.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;

    @ManyToOne
    private Post post;

    @OneToMany (mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = false )
    @JsonIgnore
    private List<Liked> likes;
}
