package com.codestates.seb41_pre_011.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    private int questionId;
    private String title;
    private String questionContent;
    private String attemptContent;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}