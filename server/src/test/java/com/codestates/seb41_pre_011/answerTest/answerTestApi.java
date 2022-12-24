package com.codestates.seb41_pre_011.answerTest;

import com.codestates.seb41_pre_011.answer.controller.AnswerController;
import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.mapper.AnswerMapper;
import com.codestates.seb41_pre_011.answer.service.AnswerService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;

import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnswerController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class answerTestApi {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    @MockBean
    private AnswerMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postAnswerTest() throws Exception {
        //given
        AnswerDto.Post post = new AnswerDto.Post("댓글1");
        String content = gson.toJson(post);
        AnswerDto.Response response = new AnswerDto.Response(1, "댓글1", LocalDateTime.now(), LocalDateTime.now());

        given(mapper.answerPostDtoToAnswer(Mockito.any(AnswerDto.Post.class))).willReturn(new Answer());
        given(answerService.createAnswer(Mockito.any(Answer.class))).willReturn(new Answer());
        given(mapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(response);

        // when
        ResultActions actions =
                mockMvc.perform(
                        post("/v1/answer")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
        //then
        actions.andExpect(status().isCreated())
                .andDo(document("post-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("댓글")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("댓글 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("댓글"),
                                        fieldWithPath("data.createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data.modifiedDate").type(JsonFieldType.STRING).description("수정시간")
                                )
                        )
                ));
    }

    @Test
    public void patchAnswerTest() throws Exception {
        //given
        AnswerDto.Patch patch = new AnswerDto.Patch("댓글",1);
        String content = gson.toJson(patch);
        AnswerDto.Response response = new AnswerDto.Response(1,"댓글", LocalDateTime.now(), LocalDateTime.now());
        given(mapper.answerPatchDtoToAnswer(Mockito.any(AnswerDto.Patch.class))).willReturn(new Answer());
        given(answerService.updateAnswer(Mockito.any(Answer.class))).willReturn(new Answer());
        given(mapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(response);

        //when
        ResultActions actions =
                mockMvc.perform(
                        patch("/v1/answer/{answer-id}", 1)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.answerId").value(patch.getAnswerId()))
                .andExpect(jsonPath("$.data.content").value(patch.getContent()))
                .andDo(document("patch-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("댓글 식별자")

                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("댓글 식별자").ignored(),
                                        fieldWithPath("content").type(JsonFieldType.STRING).description("댓글").optional()
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("댓글 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("댓글"),
                                        fieldWithPath("data.createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data.modifiedDate").type(JsonFieldType.STRING).description("수정시간")
                                )
                        )
                ));
    }
    @Test
    public void getAnswerTest() throws Exception {
        //given
        int answerId = 1;
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        answer.setContent("답변");
        answer.setCreatedDate(LocalDateTime.now());
        answer.setModifiedDate(LocalDateTime.now());

        AnswerDto.Response response = new AnswerDto.Response(1,"답변", LocalDateTime.now(), LocalDateTime.now());

        given(answerService.findAnswer(Mockito.anyInt())).willReturn(answer);
        given(mapper.answerToAnswerResponseDto(Mockito.any(Answer.class))).willReturn(response);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v1/answer/{answer-id}", answerId)
                        .accept(MediaType.APPLICATION_JSON));

        // then
        actions.andExpect(status().isOk())
                .andDo(document("get-answer",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("answer-id").description("답변 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.answerId").type(JsonFieldType.NUMBER).description("댓글 식별자"),
                                        fieldWithPath("data.content").type(JsonFieldType.STRING).description("댓글"),
                                        fieldWithPath("data.createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data.modifiedDate").type(JsonFieldType.STRING).description("수정시간")
                                )
                        )
                ));
    }
    @Test
    public void getAnswers() throws Exception{
        //given
        int answerId1 = 1;
        Answer answer1 = new Answer();
        answer1.setAnswerId(answerId1);
        answer1.setContent("답변1");
        answer1.setCreatedDate(LocalDateTime.now());
        answer1.setModifiedDate(LocalDateTime.now());

        int answerId2 = 2;
        Answer answer2 = new Answer();
        answer2.setAnswerId(answerId2);
        answer2.setContent("답변2");
        answer2.setCreatedDate(LocalDateTime.now());
        answer2.setCreatedDate(LocalDateTime.now());

        AnswerDto.Response response1 = new AnswerDto.Response(1,"답변1", LocalDateTime.now(), LocalDateTime.now());
        AnswerDto.Response response2 = new AnswerDto.Response(2,"답변2", LocalDateTime.now(), LocalDateTime.now());

        int page = 2;
        int size = 10;

        Page<Answer> answers = new PageImpl<>(List.of(answer1, answer2), PageRequest.of(page-1, size,
                Sort.by("memberId").descending()), 2);

        List<AnswerDto.Response> responses = List.of(response1, response2);

        given(answerService.findAnswers(Mockito.anyInt(), Mockito.anyInt())).willReturn(answers);
        given(mapper.answersToAnswerResponseDto(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions actions =
                mockMvc.perform(
                        get("/v1/answer")
                                .param("page", String.valueOf(page))
                                .param("size", String.valueOf(size))
                                .accept(MediaType.APPLICATION_JSON)
                );
        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andDo(document(
                        "get-answers",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                parameterWithName("page").description("페이지"),
                                parameterWithName("size").description("사이즈")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[].answerId").type(JsonFieldType.NUMBER).description("댓글 식별자"),
                                        fieldWithPath("data[].content").type(JsonFieldType.STRING).description("댓글"),
                                        fieldWithPath("data[].createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data[].modifiedDate").type(JsonFieldType.STRING).description("수정시간"),

                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("페이지 요소 수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")

                                )
                        )
                ));
    }
}