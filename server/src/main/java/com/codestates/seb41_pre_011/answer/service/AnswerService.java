package com.codestates.seb41_pre_011.answer.service;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.repository.AnswerRepository;
import com.codestates.seb41_pre_011.exception.BusinessLogicException;
import com.codestates.seb41_pre_011.exception.ExceptionCode;
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
        if(answer.getModifiedDate() == null) {answer.setModifiedDate(LocalDateTime.now());}
        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer(int answerId) {
        Answer answer = findVerifiedAnswer(answerId);
        return answer;
    }

    public List<Answer> findAnswers() {
        return answerRepository.findAll();
    }

    public void deleteAnswer(int answerId) { answerRepository.deleteById(answerId);
    }

    private Answer findVerifiedAnswer(int answerId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Answer findAnswer = optionalAnswer.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));
        return findAnswer;
    }
}
