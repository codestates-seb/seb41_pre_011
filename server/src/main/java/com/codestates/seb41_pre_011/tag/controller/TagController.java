package com.codestates.seb41_pre_011.tag.controller;

import com.codestates.seb41_pre_011.tag.dto.TagDto;
import com.codestates.seb41_pre_011.tag.dto.TagPatchDto;
import com.codestates.seb41_pre_011.tag.dto.TagPostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.Arrays;

@RestController
@RequestMapping("/v1/tag")
public class TagController {
    @PostMapping
    public ResponseEntity postTag(@RequestBody TagPostDto tagPostDto) {
        return ResponseEntity.created(URI.create("v1/tag/1")).build();
    }

    @PatchMapping("/{tag-id}")
    public ResponseEntity patchTag(@PathVariable("tag-id") @Positive int tagId,
                                   @RequestBody TagPatchDto tagPatchDto) {
        TagDto.Response response = new TagDto.Response(1, "spring", "스프링", 1);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{tag-id}")
    public ResponseEntity getTag(@PathVariable("tag-id") @Positive int tagId) {
        TagDto.Response response = new TagDto.Response(1, "spring", "스프링", 1);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getTags() {
        TagDto.Response response1 = new TagDto.Response(1, "spring", "스프링", 1);
        TagDto.Response response2 = new TagDto.Response(2, "java", "자바", 2);
        return ResponseEntity.ok(Arrays.asList(response1, response2));
    }

    @DeleteMapping("/{tag-id}")
    public ResponseEntity deleteTag(@PathVariable("tag-id") @Positive int tagId) {
        return ResponseEntity.noContent().build();
    }
}
