package com.codestates.seb41_pre_011.member.controller;

import com.codestates.seb41_pre_011.dto.MultiResponseDto;
import com.codestates.seb41_pre_011.dto.SingleResponseDto;
import com.codestates.seb41_pre_011.member.dto.MemberDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.member.mapper.MemberMapper;
import com.codestates.seb41_pre_011.member.service.MemberService;
import com.codestates.seb41_pre_011.utils.UriCreater;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RestController
@RequestMapping("/v1/member")
@Validated
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/v1/member";
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @CrossOrigin(exposedHeaders = "Authorization")
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestbody) {
        Member member = memberMapper.memberPostDtoToMember(requestbody);
        Member createMember = memberService.createMember(member);
        URI location = UriCreater.createUri(MEMBER_DEFAULT_URL, createMember.getMemberId());

        MemberDto.Response response = memberMapper.memberToMemberResponseDto(createMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{member-email}")
    public ResponseEntity patchMember(@PathVariable("member-email") String memberEmail,
                                      @Valid @RequestBody MemberDto.Patch requestbody) {
        Member findMember = memberService.findMember(memberEmail);
        requestbody.setMemberId(findMember.getMemberId());
        Member updateMember = memberService.updateMember(memberMapper.memberPatchDtoToMember(requestbody));
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(updateMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.OK);
    }

    @GetMapping("/{member-email}")
    public ResponseEntity getMember(@PathVariable("member-email") String memberEmail) {
        Member findMember = memberService.findMember(memberEmail);
        MemberDto.Response response = memberMapper.memberToMemberResponseDto(findMember);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@RequestParam int page,
                                     @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(memberMapper.membersToMemberResponseDto(members),
                        pageMembers),
                HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive int memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

