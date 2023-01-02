package com.codestates.seb41_pre_011.answer.mapper;

import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerDto.Post RequestBody);
    Answer answerPatchDtoToAnswer(AnswerDto.Patch RequestBody);
    default AnswerDto.Response answerToAnswerResponseDto(Answer answer){
        AnswerDto.Response answerResponseDto = new AnswerDto.Response();

        answerResponseDto.setAnswerId(answer.getAnswerId());
        answerResponseDto.setQuestionId(answer.getQuestionId());
        answerResponseDto.setMemberName(answer.getMember().getName());
        answerResponseDto.setMemberImage(answer.getMember().getImage());
        answerResponseDto.setContent(answer.getContent());
        answerResponseDto.setCreatedDate(answer.getCreatedDate());
        answerResponseDto.setModifiedDate(answer.getModifiedDate());
        answerResponseDto.setTags(answer.getTags());

        return answerResponseDto;
    };
    List<AnswerDto.Response> answersToAnswerResponseDto(List<Answer> answers);
}
