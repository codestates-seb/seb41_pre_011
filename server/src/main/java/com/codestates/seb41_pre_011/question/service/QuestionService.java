package com.codestates.seb41_pre_011.question.service;

import com.codestates.seb41_pre_011.exception.BusinessLogicException;
import com.codestates.seb41_pre_011.exception.ExceptionCode;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.question.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        if(question.getCreatedDate() == null) {question.setCreatedDate(LocalDateTime.now());}
        if(question.getModifiedDate() == null) {question.setModifiedDate(LocalDateTime.now());}
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());
        Optional.ofNullable(question.getTitle()).ifPresent(findQuestion::setTitle);
        Optional.ofNullable(question.getQuestionContent()).ifPresent(findQuestion::setQuestionContent);
        Optional.ofNullable(question.getAttemptContent()).ifPresent(findQuestion::setAttemptContent);
        if(question.getModifiedDate() == null) {question.setModifiedDate(LocalDateTime.now());}
        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(int questionId) {
        Question question = findVerifiedQuestion(questionId);
        return question;
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size,
                Sort.by("questionId").descending()));
    }

    public void deleteQuestion(int questionId) { questionRepository.deleteById(questionId);
    }

    public Question findVerifiedQuestion(int questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question findQuestion = optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return findQuestion;
    }
}
