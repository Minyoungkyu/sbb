package com.example.sbb.question;


import com.example.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id // Primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // Auto_Increment
    private Integer id;

    @Column( length = 200 ) // char(200?)
    private String subject;

    @Column( columnDefinition = "Text" ) // Type Text
    private String content;

    @CreationTimestamp
    private LocalDateTime createDate;

    @OneToMany( mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;


}
