package com.codestates.seb41_pre_011.tag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagPatchDto {
    private int tagId;
    private String description;
    private int count;
}
