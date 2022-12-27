package com.codestates.seb41_pre_011.tag.service;

import com.codestates.seb41_pre_011.exception.BusinessLogicException;
import com.codestates.seb41_pre_011.exception.ExceptionCode;
import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import com.codestates.seb41_pre_011.tag.repository.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag) {
        tag.setCount(0);
        return tagRepository.save(tag);
    }
    public Tag updateTag(Tag tag) {
        Tag findTag =findVerifiedTag(tag.getTagId());
        Optional.ofNullable(tag.getDescription()).ifPresent(findTag::setDescription);
        return tagRepository.save(findTag);
    }

    public Tag findTag(int tagId) {
        Tag tag = findVerifiedTag(tagId);
        return tag;
    }

    public Page<Tag> findTags(int page, int size) {
        return tagRepository.findAll(PageRequest.of(page, size, Sort.by("tagId").descending()));
    }

    public void deleteTag(int tagId) {tagRepository.deleteById(tagId);}

    public Tag findVerifiedTag(int tagId) {
        Optional<Tag> optionalTag = tagRepository.findById(tagId);
        Tag findTag = optionalTag.orElseThrow(() -> new BusinessLogicException(ExceptionCode.TAG_NOT_FOUND));
        return findTag;
    }
}