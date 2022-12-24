package com.codestates.seb41_pre_011.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TagDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String name;
        private String description;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
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
