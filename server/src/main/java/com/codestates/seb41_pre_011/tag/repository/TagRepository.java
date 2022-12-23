package com.codestates.seb41_pre_011.tag.repository;

import com.codestates.seb41_pre_011.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
