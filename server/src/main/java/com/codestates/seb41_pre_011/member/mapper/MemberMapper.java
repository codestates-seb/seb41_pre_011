package com.codestates.seb41_pre_011.member.mapper;

import com.codestates.seb41_pre_011.member.dto.MemberPatchDto;
import com.codestates.seb41_pre_011.member.dto.MemberPostDto;
import com.codestates.seb41_pre_011.member.dto.MemberResponseDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoTomMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> membersToMemberResponseDtos(List<Member> members);
}
