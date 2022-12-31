package com.codestates.seb41_pre_011.question.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TagQuestionResponseDto {
    private int tagId;
    private String name;
    private String description;
    private int count;
}
