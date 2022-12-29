package com.codestates.seb41_pre_011.answer.service;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.repository.AnswerRepository;
import com.codestates.seb41_pre_011.exception.BusinessLogicException;
import com.codestates.seb41_pre_011.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        Optional.ofNullable(answer.getContent()).ifPresent(findAnswer::setContent);
        Optional.ofNullable(answer.getTags()).ifPresent(findAnswer::setTags);
        if(answer.getModifiedDate() == null) {answer.setModifiedDate(LocalDateTime.now());}
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(int answerId) {
        Answer answer = findVerifiedAnswer(answerId);
        return answer;
    }
    public List<Answer> findByQuestion(int questionId){
        return answerRepository.findByQuestionId(questionId);
    }

    public Page<Answer> findAnswers(int page, int size) {
        return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").descending()));
    }

    public void deleteAnswer(int answerId) { answerRepository.deleteById(answerId);
    }

    private Answer findVerifiedAnswer(int answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }
}
