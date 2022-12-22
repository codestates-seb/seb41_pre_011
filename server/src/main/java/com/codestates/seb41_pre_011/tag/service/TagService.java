package com.codestates.seb41_pre_011.tag.service;

import com.codestates.seb41_pre_011.tag.entity.Tag;
import com.codestates.seb41_pre_011.tag.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
    public Tag updateTag(Tag tag) {
        Tag findTag =findTag(tag.getTagId());
        Optional.ofNullable(tag.getDescription()).ifPresent(findTag::setDescription);
        Optional.ofNullable(tag.getCount()).ifPresent(findTag::setCount);
        return tagRepository.save(findTag);
    }

    public Tag findTag(int tagId) {
        Tag tag = new Tag();
        return tag;
    }

    public List<Tag> findTags() {
        return tagRepository.findAll();
    }

    public void deleteTag(int tagId) {tagRepository.deleteById(tagId);}
}