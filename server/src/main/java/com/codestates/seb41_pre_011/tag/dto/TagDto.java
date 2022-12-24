package com.codestates.seb41_pre_011.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class TagDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "태그를 입력해 주세요.")
        private String name;
        @NotBlank(message = "설명을 입력해 주세요.")
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private int tagId;
        @NotBlank(message = "수정할 설명을 입력해 주세요.")
        private String description;
        private int count;

        public void setTagId(int tagId) {this.tagId = tagId;}
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int tagId;
        private String name;
        private String description;
        private int count;
    }
}
