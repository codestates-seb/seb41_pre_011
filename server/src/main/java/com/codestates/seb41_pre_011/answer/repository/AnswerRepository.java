package com.codestates.seb41_pre_011.answer.repository;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(int questionId);
}
