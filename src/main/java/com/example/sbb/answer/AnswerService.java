package com.example.sbb.answer;

import com.example.sbb.DataNotFoundException;
import com.example.sbb.question.Question;
import com.example.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {

        Answer answer = new Answer();

        answer.setContent(content);
        answer.setQuestion(question);
        answer.setAuthor(author);

        this.answerRepository.save(answer);

        return answer;
    }

    public Answer getAnswer(Integer id) {

        Optional<Answer> answer = this.answerRepository.findById(id);

        if(answer.isPresent()) {

            return answer.get();

        } else {

            throw new DataNotFoundException("answer not found");

        }
    }

    public void modify(Answer answer, String content) {

        answer.setContent(content);

        this.answerRepository.save(answer);

    }

    public void delete(Answer answer) {

        this.answerRepository.delete(answer);

    }


}
