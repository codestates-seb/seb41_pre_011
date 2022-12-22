package com.codestates.seb41_pre_011.member.controller;

import com.codestates.seb41_pre_011.member.dto.MemberDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.member.mapper.MemberMapper;
import com.codestates.seb41_pre_011.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/member")
@Validated
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.Post requestbody) {
        Member member = memberMapper.memberPostDtoToMember(requestbody);
        Member createMember = memberService.createMember(member);
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(createMember);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive int memberId,
                                      @RequestBody MemberDto.Patch requestbody) {
        requestbody.setMemberId(memberId);
        Member updateMember = memberService.updateMember(memberMapper.memberPatchDtoToMember(requestbody));
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(updateMember);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive int memberId) {
        Member findMember = memberService.findMember(memberId);
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(findMember);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        List<MemberDto.Response> response = members.stream().map(member -> memberMapper.memberToMemberResponseDto(member))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive int memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

