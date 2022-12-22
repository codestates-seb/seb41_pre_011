package com.codestates.seb41_pre_011.question.service;

import com.codestates.seb41_pre_011.question.entity.Question;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {
    public Question createQuestion(Question question) {
        Question createdMember = question;
        return createdMember;
    }

    public Question updateQuestion(Question question) {
        Question updatedQuestion = question;
        return updatedQuestion;
    }

    public Question findQuestion(int questionId) {
        Question question =
                new Question(questionId, "자바 질문", "자바를 모르겠습니다.","시도했습니다", LocalDateTime.now(),LocalDateTime.now());
        return question;
    }

    public List<Question> findQuestions() {
        List<Question> questions = List.of(
                new Question(1, "자바 질문", "자바를 모르겠습니다.","시도했습니다", LocalDateTime.now(),LocalDateTime.now()),
                new Question(2, "스프링 질문", "스프링을 모르겠습니다.","고쳤습니다", LocalDateTime.now(),LocalDateTime.now())
        );
        return questions;
    }

    public void deleteQuestion(int questionId) {
    }
}
