package com.codestates.seb41_pre_011.member.service;

import com.codestates.seb41_pre_011.auth.utils.CustomAuthorityUtils;
import com.codestates.seb41_pre_011.exception.BusinessLogicException;
import com.codestates.seb41_pre_011.exception.ExceptionCode;
import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());

        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: DB에 User Role 저장
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        int randImage = randBetween(1,400);
        if(member.getImage()==null) {member.setImage("https://avatars.dicebear.com/api/bottts/2" + randImage + ".svg");}

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());
        Optional.ofNullable(member.getName()).ifPresent(findMember::setName);
        Optional.ofNullable(member.getPassword()).ifPresent(findMember::setPassword);
        Optional.ofNullable(member.getImage()).ifPresent(findMember::setImage);
        return memberRepository.save(findMember);
    }

    public Member findMember(int memberId) {
        Member member = findVerifiedMember(memberId);
        member.setPassword(null);
        return member;
    }

    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));
    }
    public void deleteMember(int memberId) {memberRepository.deleteById(memberId);}

    private static final Random rng = new Random();

    public static int randBetween(int min, int max) {return min+rng.nextInt(max-min+1);}

    public Member findVerifiedMember(int memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findmember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findmember;
    }
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}