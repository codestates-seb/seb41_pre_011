package com.codestates.seb41_pre_011.tag.service;

import com.codestates.seb41_pre_011.tag.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    public Tag createTag(Tag tag) {
        Tag createTag = tag;
        return createTag;
    }
    public Tag updateTag(Tag tag) {
        Tag updateTag = tag;
        return updateTag;
    }

    public Tag findTag(int tagId) {
        Tag tag = new Tag(1, "spring", "boot", 1);
        return tag;
    }

    public List<Tag> findTags() {
        List<Tag> Tags = List.of(
                new Tag(1,"kch@gmail.com" , "홍길동", 3),
                new Tag(2,"chk@gmail.com" , "김코딩", 4)
        );
        return Tags;
    }

    public static void deleteTag(int TagId) {}
}