package com.codestates.seb41_pre_011.question;

import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.question.controller.QuestionController;
import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.question.mapper.QuestionMapper;
import com.codestates.seb41_pre_011.question.service.QuestionService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class QuestionTestApi {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postQuestionTest() throws Exception {
        //given
        QuestionDto.Post post = new QuestionDto.Post("제목", "내용1", "내용2");
        String content = gson.toJson(post);
        List<String> tags = new ArrayList<>();
        QuestionDto.Response response = new QuestionDto.Response(1, "제목","내용1", "내용2", LocalDateTime.now(), LocalDateTime.now(),"김코딩", tags, 1);

        given(mapper.questionPostToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);

        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/v1/question")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
        //then
        actions.andExpect(status().isCreated())
                .andDo(document("post-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("내용1"),
                                        fieldWithPath("attemptContent").type(JsonFieldType.STRING).description("내용2")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data.title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("내용1"),
                                        fieldWithPath("data.attemptContent").type(JsonFieldType.STRING).description("내용2"),
                                        fieldWithPath("data.createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data.modifiedDate").type(JsonFieldType.STRING).description("수정시간"),
                                        fieldWithPath("data.tag").type(JsonFieldType.STRING).description("태그"),
                                        fieldWithPath("data.likes").type(JsonFieldType.NUMBER).description("라이키")
                                )
                        )
                ));
    }
}
