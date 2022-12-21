package com.codestates.seb41_pre_011.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public class post {
        private String email;
        private String name;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public class patch {
        private int memberId;
        private String name;
        private String password;

        public void setMemberId(int memberId) {this.memberId = memberId;}
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int memberId;
        private String email;
        private String name;
        private String password;
    }
}