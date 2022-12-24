package com.codestates.seb41_pre_011.tag.mapper;

import com.codestates.seb41_pre_011.tag.dto.TagDto;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagDto.Post requestbody);
    Tag tagPatchDtoToTag(TagDto.Patch requestbody);
    TagDto.Response tagToTagResponseDto(Tag tag);
    List<TagDto.Response> tagsToTagResponseDto(List<Tag> tags);
}
