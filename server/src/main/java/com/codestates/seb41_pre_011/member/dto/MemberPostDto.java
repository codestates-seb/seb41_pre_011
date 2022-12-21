package com.codestates.seb41_pre_011.member.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class MemberPostDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "이름이 공백입니다.")
    private String name;

    @NotBlank(message = "비밀번호가 공백입니다.")
    private String password;
}
