package com.codestates.seb41_pre_011.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class AnswerDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private String content;
        private int answerId;
        public void setAnswerId(int answerId) {this.answerId = answerId;}
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int answerId;
        private String content;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
