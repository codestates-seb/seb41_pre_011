package com.codestates.seb41_pre_011.question.mapper;

import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import com.codestates.seb41_pre_011.question.dto.TagQuestionDto;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.question.entity.TagQuestion;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    default Question questionPostToQuestion(QuestionDto.Post requestBody) {
        Question question = new Question();
        List<TagQuestion> tagQuestions = requestBody.getTags().stream()
                .map(tagQuestionDto -> {
                    TagQuestion tagQuestion = new TagQuestion();
                    Tag tag = new Tag();
                    tag.setTagId(tagQuestionDto.getTagId());
                    tagQuestion.addTag(tag);
                    tagQuestion.addQuestion(question);
                    return tagQuestion;}).collect(Collectors.toList());
        question.setTagQuestions(tagQuestions);
        return question;
    };
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
