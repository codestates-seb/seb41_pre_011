package com.codestates.seb41_pre_011.member.mapper;

import com.codestates.seb41_pre_011.member.dto.MemberDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberDto.Post requestbody);
    Member memberPatchDtoTomMember(MemberDto.Patch requestbody);
    MemberDto.Response memberToMemberResponseDto(Member member);
    List<MemberDto.Response> membersToMemberResponseDtos(List<Member> members);
}
