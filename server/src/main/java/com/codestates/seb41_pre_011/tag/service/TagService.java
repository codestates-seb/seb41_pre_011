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
                new Tag(1,"spring" , "프로그램", 20),
                new Tag(2,"python" , "프로그램", 19),
                new Tag(3,"python" , "프로그램", 18),
                new Tag(4,"c#" , "프로그램", 17),
                new Tag(5,"android" , "프로그램", 16),
                new Tag(6,"android" , "프로그램", 15),
                new Tag(7,"jquery" , "프로그램", 14),
                new Tag(8,"c++" , "프로그램", 13),
                new Tag(9,"c++" , "프로그램", 12),
                new Tag(10,"ios" , "프로그램", 11),
                new Tag(11,"mysql" , "프로그램", 10),
                new Tag(12,"sql" , "프로그램", 11),
                new Tag(13,"node.js" , "프로그램", 11),
                new Tag(14,"reactjs" , "프로그램", 11),
                new Tag(15,"arrays" , "프로그램", 11),
                new Tag(16,"asp.net" , "프로그램", 11),
                new Tag(17,"json" , "프로그램", 11),
                new Tag(18,"json" , "프로그램", 11),
                new Tag(19,"python-3.x" , "프로그램", 11),
                new Tag(20,"django" , "프로그램", 11)

        );
        return Tags;
    }

    public static void deleteTag(int TagId) {}
}