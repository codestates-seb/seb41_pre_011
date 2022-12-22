package com.codestates.seb41_pre_011.member.service;

import com.codestates.seb41_pre_011.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member) {
        Member createMember = member;
        return createMember;
    }

    public Member updateMember(Member member) {
        Member updateMember = member;
        return updateMember;
    }

    public Member findMember(int memberId) {
        Member member = new Member(memberId,"kch@gmail.com" , "홍길동", "비밀번호", "https://avatars.dicebear.com/api/bottts/222.svg");
        return member;
    }

    public List<Member> findMembers() {
        List<Member> members = List.of(
                new Member(1,"kch@gmail.com" , "홍길동", "비밀번호", "https://avatars.dicebear.com/api/bottts/221.svg"),
                new Member(2,"chk@gmail.com" , "김코딩", "번호비밀", "https://avatars.dicebear.com/api/bottts/220.svg")
        );
        return members;
    }
    public void deleteMember(int memberId) {}
}

