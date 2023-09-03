package com.example.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findBySubject(String Subject);
    Question findBySubjectAndContent(String Subject, String Content);
    List<Question> findBySubjectLike(String Subject);
    Page<Question> findAll(Pageable pageable);

}
