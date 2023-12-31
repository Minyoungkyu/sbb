package com.example.sbb.question;

import com.example.sbb.DataNotFoundException;
import com.example.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {

        Optional<Question> question= this.questionRepository.findById(id);

        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content, SiteUser user) {

        Question q = new Question();

        q.setSubject(subject);
        q.setContent(content);
        q.setAuthor(user);

        this.questionRepository.save(q);
    }

    public Page<Question> getList(int page) {

        List<Sort.Order> sorts = new ArrayList<>();

        sorts.add(Sort.Order.desc("createDate"));

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        return this.questionRepository.findAll(pageable);
    }

//    @Transactional
    public void modify(Question question, String subject, String content) {

        question.setSubject(subject);
        question.setContent(content);

//        Optional<Question> question1 = this.questionRepository.findById(question.getId());

//        if(question1.isPresent()) {
//            question1.get().setSubject(subject);
//            question1.get().setContent(content);
//        }

        this.questionRepository.save(question);
    }

    public void delete(Question question) {

        this.questionRepository.delete(question);

    }


}
