package com.codestates.seb41_pre_011.question.dto;

import com.codestates.seb41_pre_011.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank(message = "제목을 입력해 주세요.")
        private String title;
        @NotBlank(message = "내용을 입력해 주세요.")
        private String questionContent;
        @NotBlank(message = "내용을 입력해 주세요.")
        private String attemptContent;
        private List<String> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{
        private int questionId;
        @NotBlank(message = "수정할 제목을 입력해 주세요.")
        private String title;
        @NotBlank(message = "수정할 내용을 입력해 주세요.")
        private String questionContent;
        @NotBlank(message = "수정할 내용을 입력해 주세요.")
        private String attemptContent;
        private List<String> tags;

        public void setQuestionId(int questionId) {this.questionId = questionId;}
    }

    @Getter
    @Setter
//    @AllArgsConstructor
    public static class Response{
        private int questionId;
        private String title;
        private String questionContent;
        private String attemptContent;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;
        private String memberName;
        private List<String> tags;

        public void setMember(Member member) {this.memberName = member.getName();}
    }
}
