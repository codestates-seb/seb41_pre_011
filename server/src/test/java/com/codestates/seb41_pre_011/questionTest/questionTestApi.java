package com.codestates.seb41_pre_011.questionTest;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QuestionController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class questionTestApi {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postQuestionTest() throws Exception{
        //given
        QuestionDto.Post post = new QuestionDto.Post("제목", "내용1", "내용2");
        String content = gson.toJson(post);
        List<String> tag = new ArrayList<>();
        QuestionDto.Response response = new QuestionDto.Response(1,"제목","내용1","내용2",LocalDateTime.now(),LocalDateTime.now(),"작성자",tag,1);

        given(mapper.questionPostToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(new Question());
        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);
        //when
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
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("질문"),
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
                                        fieldWithPath("data.memberName").type(JsonFieldType.STRING).description("작성자"),
                                        fieldWithPath("data.tag").type(JsonFieldType.ARRAY).description("태그"),
                                        fieldWithPath("data.likes").type(JsonFieldType.NUMBER).description("좋아요")
                                )
                        )
                ));
    }

    @Test
    public void patchQuestionTest() throws Exception {
        //given
        QuestionDto.Patch patch = new QuestionDto.Patch(1,"제목","내용1","내용2");
        String content = gson.toJson(patch);
        List<String> tag = new ArrayList<>();
        QuestionDto.Response response = new QuestionDto.Response(1,"제목","내용1","내용2",LocalDateTime.now(),LocalDateTime.now(),"작성자",tag,1);

        given(mapper.questionPatchToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);

        //when
        ResultActions actions =
                mockMvc.perform(
                        patch("/v1/question/{question-id}", 1)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.questionId").value(patch.getQuestionId()))
                .andExpect(jsonPath("$.data.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.data.questionContent").value(patch.getQuestionContent()))
                .andExpect(jsonPath("$.data.attemptContent").value(patch.getAttemptContent()))
                .andDo(document("patch-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문 식별자")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목").optional(),
                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("내용1").optional(),
                                        fieldWithPath("attemptContent").type(JsonFieldType.STRING).description("내용2").optional()
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
                                        fieldWithPath("data.memberName").type(JsonFieldType.STRING).description("작성자"),
                                        fieldWithPath("data.tag").type(JsonFieldType.ARRAY).description("태그"),
                                        fieldWithPath("data.likes").type(JsonFieldType.NUMBER).description("좋아요")
                                )
                        )
                ));
    }

    @Test
    public void getQuestionTest() throws Exception {
        int questionId = 1;
        Question question = new Question();
        question.setQuestionId(questionId);
        question.setTitle("질문");
        question.setQuestionContent("내용1");
        question.setAttemptContent("내용2");
        question.setCreatedDate(LocalDateTime.now());
        question.setModifiedDate(LocalDateTime.now());
        List<String> tag = new ArrayList<>();
        QuestionDto.Response response = new QuestionDto.Response(1, "제목", "내용1", "내용2", LocalDateTime.now(), LocalDateTime.now(), "작성자", tag, 1);

        given(questionService.findQuestion(Mockito.anyInt())).willReturn(question);
        given(mapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);

        //when
        ResultActions actions = mockMvc.perform(
                get("/v1/question/{question-id}", questionId)
                        .accept(MediaType.APPLICATION_JSON));

        //then
        actions.andExpect(status().isOk())
                .andDo(document("get-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("question-id").description("질문 식별자")
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
                                        fieldWithPath("data.memberName").type(JsonFieldType.STRING).description("작성자"),
                                        fieldWithPath("data.tag").type(JsonFieldType.ARRAY).description("태그"),
                                        fieldWithPath("data.likes").type(JsonFieldType.NUMBER).description("좋아요")
                                )
                        )
                ));
    }

    @Test
    public void getQuestionsTest() throws Exception {
        //given
        int questionId1 = 1;
        Question question1 = new Question();
        question1.setQuestionId(questionId1);
        question1.setTitle("제목1");
        question1.setQuestionContent("내용1");
        question1.setAttemptContent("내용2");
        question1.setCreatedDate(LocalDateTime.now());
        question1.setModifiedDate(LocalDateTime.now());
        List<String> tag1 = new ArrayList<>();

        int questionId2 = 2;
        Question question2 = new Question();
        question2.setQuestionId(questionId1);
        question2.setTitle("제목2");
        question2.setQuestionContent("내용3");
        question2.setAttemptContent("내용4");
        question2.setCreatedDate(LocalDateTime.now());
        question2.setModifiedDate(LocalDateTime.now());
        List<String> tag2 = new ArrayList<>();

        QuestionDto.Response response1 = new QuestionDto.Response(1, "제목1", "내용1", "내용2", LocalDateTime.now(), LocalDateTime.now(), "작성자1", tag1, 1);
        QuestionDto.Response response2 = new QuestionDto.Response(2, "제목2", "내용3", "내용4", LocalDateTime.now(), LocalDateTime.now(), "작성자2", tag2, 2);

        int page = 2;
        int size = 10;

        Page<Question> questions = new PageImpl<>(List.of(question1, question2), PageRequest.of(page-1, size,
                Sort.by("questionId").descending()), 2);

        List<QuestionDto.Response> responses = List.of(response1, response2);

        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt())).willReturn(questions);
        given(mapper.questionsToQuestionResponses(Mockito.anyList())).willReturn(responses);

        //when
        ResultActions actions =
                mockMvc.perform(
                        get("/v1/question")
                                .param("page", String.valueOf(page))
                                .param("size", String.valueOf(size))
                                .accept(MediaType.APPLICATION_JSON)
                );

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andDo(document(
                        "get-questions",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                parameterWithName("page").description("페이지"),
                                parameterWithName("size").description("사이즈")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
                                        fieldWithPath("data[].title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("data[].questionContent").type(JsonFieldType.STRING).description("내용1"),
                                        fieldWithPath("data[].attemptContent").type(JsonFieldType.STRING).description("내용2"),
                                        fieldWithPath("data[].createdDate").type(JsonFieldType.STRING).description("생성시간"),
                                        fieldWithPath("data[].modifiedDate").type(JsonFieldType.STRING).description("수정시간"),
                                        fieldWithPath("data[].memberName").type(JsonFieldType.STRING).description("작성자"),
                                        fieldWithPath("data[].tag").type(JsonFieldType.ARRAY).description("태그"),
                                        fieldWithPath("data[].likes").type(JsonFieldType.NUMBER).description("좋아요"),

                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("페이지 요소 수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                )
                        )
                ));
    }

    @Test
    public void deleteQuestionTest() throws Exception {
        //given
        int questionId = 1;

        //when
        ResultActions actions = mockMvc.perform(
                delete("/v1/question/{question-id}", questionId).accept(MediaType.APPLICATION_JSON));

        //then
        actions.andExpect(status().isNoContent())
                .andDo(MockMvcRestDocumentation.document("delete-question",
                                pathParameters(
                                        parameterWithName("question-id").description("질문 식별자")
                                )
                        )

                );
    }
}
