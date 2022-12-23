package com.codestates.seb41_pre_011.tag.controller;

import com.codestates.seb41_pre_011.tag.dto.TagDto;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import com.codestates.seb41_pre_011.tag.mapper.TagMapper;
import com.codestates.seb41_pre_011.tag.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/tag")
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    public TagController(TagService tagservice, TagMapper tagMapper) {
        this.tagService = tagservice;
        this.tagMapper = tagMapper;
    }

    @PostMapping
    public ResponseEntity postTag(@RequestBody TagDto.Post requestbody) {
        Tag tag = tagMapper.tagPostDtoToTag(requestbody);
        Tag createTag = tagService.createTag(tag);
        TagDto.Response response = tagMapper.tagToTagResponseDto(createTag);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{tag-id}")
    public ResponseEntity patchTag(@PathVariable("tag-id") @Positive int tagId,
                                   @RequestBody TagDto.Patch requestbody) {
        requestbody.setTagId(tagId);
        Tag updateTag = tagService.updateTag(tagMapper.tagPatchDtoToTag(requestbody));
        TagDto.Response response = tagMapper.tagToTagResponseDto(updateTag);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{tag-id}")
    public ResponseEntity getTag(@PathVariable("tag-id") @Positive int tagId) {
        Tag findTag = tagService.findTag(tagId);
        TagDto.Response response = tagMapper.tagToTagResponseDto(findTag);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTags() {
        List<Tag> tags = tagService.findTags();
        List<TagDto.Response> response = tags.stream().map(tag -> tagMapper.tagToTagResponseDto(tag))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{tag-id}")
    public ResponseEntity deleteTag(@PathVariable("tag-id") @Positive int tagId) {
        tagService.deleteTag(tagId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
