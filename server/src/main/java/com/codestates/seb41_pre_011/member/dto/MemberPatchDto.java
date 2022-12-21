package com.codestates.seb41_pre_011.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberPatchDto {
    private int memberId;

    @NotBlank(message = "수정할 이름을 넣어주세요.")
    private String name;

    @NotBlank(message = "수정할 비밀번호를 넣어주세요.")
    private String password;

    public void setMemberId(int memberId) {this.memberId = memberId;}

}
