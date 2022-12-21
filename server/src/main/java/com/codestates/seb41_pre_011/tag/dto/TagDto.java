package com.codestates.seb41_pre_011.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TagDto {
    @Getter
    @AllArgsConstructor
    public static class post {
        private String name;
        private String description;
        private int count;
    }

    @Getter
    @AllArgsConstructor
    public static class patch {
        private int tagId;
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
