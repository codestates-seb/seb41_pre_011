package com.codestates.seb41_pre_011.answer.service;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerService {
    public Answer createAnswer(Answer answer) {
        Answer createdAnswer = answer;
        return createdAnswer;
    }

    public Answer updateAnswer(Answer answer) {
        Answer updatedAnswer = answer;
        return updatedAnswer;
    }

    public Answer findAnswer(int answerId) {
        Answer answer = new Answer(answerId, "Test answer", LocalDateTime.now(), LocalDateTime.now(), false, 1);
        return answer;
    }

    public List<Answer> findAnswers() {
        List<Answer> answers = List.of(
                new Answer(1, "Test answer1", LocalDateTime.now(), LocalDateTime.now(), false, 1),
                new Answer(2, "Test answer2", LocalDateTime.now(), LocalDateTime.now(), true, 2)
        );
        return answers;
    }

    public void deleteAnswer(int answerId) {

    }
}
