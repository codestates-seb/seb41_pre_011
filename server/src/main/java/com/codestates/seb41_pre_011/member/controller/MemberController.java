package com.codestates.seb41_pre_011.member.controller;

import com.codestates.seb41_pre_011.member.dto.MemberDto;
import com.codestates.seb41_pre_011.member.dto.MemberPatchDto;
import com.codestates.seb41_pre_011.member.dto.MemberPostDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.Arrays;

@RestController
@RequestMapping("/v1/member")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberPostDto postDto) {
        return ResponseEntity.created(URI.create("v1/member/1")).build();
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive int memberId,
                                      @RequestBody MemberPatchDto patchDto) {
        MemberDto.Response response = new MemberDto.Response(1, "홍길동", "비밀번호");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive int memberId) {
        MemberDto.Response response = new MemberDto.Response(1, "홍길동", "비밀번호");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        MemberDto.Response response1 = new MemberDto.Response(1, "홍길동", "비밀번호");
        MemberDto.Response response2 = new MemberDto.Response(2, "김코딩", "번호비밀");
        return ResponseEntity.ok(Arrays.asList(response1, response2));
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive int memberId) {
        return ResponseEntity.noContent().build();
    }
}
