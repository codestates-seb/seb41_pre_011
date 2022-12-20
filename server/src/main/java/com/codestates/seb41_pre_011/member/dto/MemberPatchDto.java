package com.codestates.seb41_pre_011.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPatchDto {
    private int memberId;
    private String name;
    private String password;

    public void setMemberId(int memberId) {this.memberId = memberId;}
}
