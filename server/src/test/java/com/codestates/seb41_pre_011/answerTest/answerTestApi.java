package com.codestates.seb41_pre_011.answerTest;

import com.codestates.seb41_pre_011.answer.controller.AnswerController;
import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.mapper.AnswerMapper;
import com.codestates.seb41_pre_011.answer.service.AnswerService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.patch;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
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
}




































