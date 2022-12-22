package com.codestates.seb41_pre_011.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        private String title;
        private String questionContent;
        private String attemptContent;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{
        private int questionId;
        private String title;
        private String questionContent;
        private String attemptContent;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private int questionId;
        private String title;
        private String questionContent;
        private String attemptContent;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
        private String memberName;
        private List<String> tag;
        private int likes;
    }
}
