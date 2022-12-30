package com.codestates.seb41_pre_011.question.mapper;

import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import com.codestates.seb41_pre_011.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question questionPostToQuestion(QuestionDto.Post requestBody);
    Question questionPatchToQuestion(QuestionDto.Patch requestBody);
    default QuestionDto.Response questionToQuestionResponse(Question question) {
        QuestionDto.Response questionResponseDto = new QuestionDto.Response();
                questionResponseDto.setQuestionId(question.getQuestionId());
                questionResponseDto.setTitle(question.getTitle());
                questionResponseDto.setQuestionContent(question.getQuestionContent());
                questionResponseDto.setAttemptContent(question.getAttemptContent());
                questionResponseDto.setCreatedDate(question.getCreatedDate());
                questionResponseDto.setModifiedDate(question.getModifiedDate());
                questionResponseDto.setMemberName(question.getMember().getName());
                questionResponseDto.setMemberImage(question.getMember().getImage());
                questionResponseDto.setTags(question.getTags());

                return questionResponseDto;
    };
    List<QuestionDto.Response> questionsToQuestionResponses(List<Question> questions);
}
