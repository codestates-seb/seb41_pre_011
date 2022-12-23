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
                new Member(1,"kch@gmail.com" , "홍길동", "비밀번호", "https://avatars.dicebear.com/api/bottts/220.svg"),
                new Member(2,"kch@gmail.com" , "김코딩", "번호비밀", "https://avatars.dicebear.com/api/bottts/221.svg"),
                new Member(3,"kch@gmail.com" , "박해커", "비밀번호", "https://avatars.dicebear.com/api/bottts/222.svg"),
                new Member(4,"kch@gmail.com" , "이자바", "비밀번호", "https://avatars.dicebear.com/api/bottts/223.svg"),
                new Member(5,"kch@gmail.com" , "최부트", "비밀번호", "https://avatars.dicebear.com/api/bottts/224.svg"),
                new Member(6,"kch@gmail.com" , "윤서울", "비밀번호", "https://avatars.dicebear.com/api/bottts/225.svg"),
                new Member(7,"kch@gmail.com" , "임강릉", "비밀번호", "https://avatars.dicebear.com/api/bottts/226.svg"),
                new Member(8,"kch@gmail.com" , "유부산", "비밀번호", "https://avatars.dicebear.com/api/bottts/227.svg"),
                new Member(9,"kch@gmail.com" , "나대구", "비밀번호", "https://avatars.dicebear.com/api/bottts/228.svg"),
                new Member(10,"kch@gmail.com" , "모전주", "비밀번호", "https://avatars.dicebear.com/api/bottts/229.svg"),
                new Member(11,"kch@gmail.com" , "손대전", "비밀번호", "https://avatars.dicebear.com/api/bottts/230.svg"),
                new Member(12,"kch@gmail.com" , "조제주", "비밀번호", "https://avatars.dicebear.com/api/bottts/231.svg"),
                new Member(13,"kch@gmail.com" , "홍안동", "비밀번호", "https://avatars.dicebear.com/api/bottts/232.svg"),
                new Member(14,"kch@gmail.com" , "김나주", "비밀번호", "https://avatars.dicebear.com/api/bottts/233.svg"),
                new Member(15,"kch@gmail.com" , "임무주", "비밀번호", "https://avatars.dicebear.com/api/bottts/234.svg"),
                new Member(16,"kch@gmail.com" , "이진주", "비밀번호", "https://avatars.dicebear.com/api/bottts/235.svg"),
                new Member(17,"kch@gmail.com" , "박속초", "비밀번호", "https://avatars.dicebear.com/api/bottts/236.svg"),
                new Member(18,"kch@gmail.com" , "최인천", "비밀번호", "https://avatars.dicebear.com/api/bottts/237.svg"),
                new Member(19,"kch@gmail.com" , "나광주", "비밀번호", "https://avatars.dicebear.com/api/bottts/238.svg"),
                new Member(20,"kch@gmail.com" , "민보령", "비밀번호", "https://avatars.dicebear.com/api/bottts/239.svg")
        );
        return members;
    }
    public void deleteMember(int memberId) {}
}

