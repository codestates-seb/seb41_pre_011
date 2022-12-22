package com.codestates.seb41_pre_011.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int memberId;
    private String email;
    private String name;
    private String password;
    private String image;
}
