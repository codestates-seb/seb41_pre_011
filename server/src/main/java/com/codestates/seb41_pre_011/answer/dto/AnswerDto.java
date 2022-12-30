package com.codestates.seb41_pre_011.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;


public class AnswerDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        @NotBlank(message = "답변을 입력하세요.")
        private String content;
        private int questionId;
        private List<String> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        @NotBlank(message = "수정할 답변을 입력하세요.")
        private String content;
        private int answerId;
        private int questionId;
        private List<String> tags;
        public void setAnswerId(int answerId) {this.answerId = answerId;}
    }

    @Setter
    @Getter
//    @AllArgsConstructor
    public static class Response {
        private int answerId;
        private int questionId;
        private String memberName;
        private String memberImage;
        private String content;
        private List<String> tags;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
    }
}
