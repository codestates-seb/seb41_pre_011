package com.codestates.seb41_pre_011.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {

        @NotBlank
        @Email(message = "이메일의 형식이 아닙니다.")
        private String email;
        @NotBlank(message = "닉네임을 입력해 주세요.")
        private String name;
        @NotBlank(message = "비밀번호를 입력해 주세요.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{10,}$", message = "영문 대소문자와 숫자, 특수문자 하나 이상을 포함하여 10자리 이상이어야 합니다.")
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private int memberId;
        @NotBlank(message = "변경할 닉네임을 입력해 주세요.")
        private String name;
        @NotBlank(message = "비밀번호를 입력해 주세요.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{10,}$", message = "영문 대소문자와 숫자, 특수문자 하나 이상을 포함하여 10자리 이상이어야 합니다.")
        private String password;
        private String image;

        public void setMemberId(int memberId) {this.memberId = memberId;}
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int memberId;
        private String email;
        private String name;
        @JsonIgnore
        private String password;
        private String image;
    }
}