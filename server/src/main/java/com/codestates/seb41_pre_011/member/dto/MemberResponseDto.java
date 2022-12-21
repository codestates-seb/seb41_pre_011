package com.codestates.seb41_pre_011.member.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private int memberId;
    private String email;
    private String name;
    private String password;
}
