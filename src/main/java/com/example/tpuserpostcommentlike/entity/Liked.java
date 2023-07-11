package com.example.tpuserpostcommentlike.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Liked {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean liked;

    private LocalDate date = formatDate(); //new Date() sous forme de date aaaa-mm-jj

    @ManyToOne
    private Comment comment;

    private LocalDate formatDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String text = date.format(formatters);
        return LocalDate.parse(text, formatters);
    };
}
