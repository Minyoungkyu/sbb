package com.example.sbb.answer;


import com.example.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
}

