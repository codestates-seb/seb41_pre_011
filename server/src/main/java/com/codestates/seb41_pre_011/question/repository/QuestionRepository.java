package com.codestates.seb41_pre_011.question.repository;

import com.codestates.seb41_pre_011.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Page<Question> findAllByTitleContaining(String search,
                                          Pageable pageable);
}