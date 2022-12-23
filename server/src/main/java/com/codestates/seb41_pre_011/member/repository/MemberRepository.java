package com.codestates.seb41_pre_011.member.repository;

import com.codestates.seb41_pre_011.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
