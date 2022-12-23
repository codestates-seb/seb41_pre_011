package com.codestates.seb41_pre_011.question.repository;

import com.codestates.seb41_pre_011.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
