package com.codestates.seb41_pre_011.memberTest;

//import com.codestates.seb41_pre_011.answer.dto.member.controller.MemberController;
//import com.codestates.seb41_pre_011.answer.dto.member.dto.MemberDto;
//import com.codestates.seb41_pre_011.answer.dto.member.entity.Member;
//import com.codestates.seb41_pre_011.answer.dto.member.mapper.MemberMapper;
//import com.codestates.seb41_pre_011.answer.dto.member.service.MemberService;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.getRequestPreProcessor;
//import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.getResponsePreProcessor;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(MemberController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class memberTestApi {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MemberService memberService;
//
//    @MockBean
//    private MemberMapper mapper;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void PostMemberTest()throws Exception {
//        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com", "홍길동", "Code^States1");
//        String content = gson.toJson(post);
//
//        MemberDto.Response responseDto =
//                new MemberDto.Response(1,"hgd@gmail.com","홍길동","Code^States1","https://avatars.dicebear.com/api/bottts/222.svg");
//
//        given(mapper.memberPostDtoToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());
//        given(memberService.createMember(Mockito.any(Member.class))).willReturn(new Member());
//        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/v1/member")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isCreated())
//                .andDo(document("post-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.image").type(JsonFieldType.STRING).description("이미지 url")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void patchMemberTest() throws Exception {
//        // given
//        MemberDto.Patch patch = new MemberDto.Patch(1, "홍길동", "Code^States1", "https://avatars.dicebear.com/api/bottts/222.svg");
//        String content = gson.toJson(patch);
//
//        MemberDto.Response responseDto =
//                new MemberDto.Response(1, "hgd@gmail.com", "홍길동", "Code^States1", "https://avatars.dicebear.com/api/bottts/222.svg");
//
//        // willReturn()이 최소한 null은 아니어야 한다.
//        given(mapper.memberPatchDtoToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
//
//        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
//
//        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        patch("/v1/member/{member-id}", 1)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
//                .andExpect(jsonPath("$.data.name").value(patch.getName()))
//                .andExpect(jsonPath("$.data.image").value(patch.getImage()))
//                .andDo(document("patch-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("member-id").description("회원 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),
//                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호").optional(),
//                                        fieldWithPath("image").type(JsonFieldType.STRING).description("https://avatars.dicebear.com/api/bottts/222.svg").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.image").type(JsonFieldType.STRING).description("이미지 주소")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void getMemberTest() throws Exception {
//        int memberId = 1;
//
//        Member member = new Member();
//        member.setMemberId(1);
//        member.setEmail("hgd@gmail.com");
//        member.setName("홍길동");
//        member.setPassword("user_password");
//        member.setImage("https://avatars.dicebear.com/api/bottts/222.svg");
//
//        MemberDto.Response responseDto =
//                new MemberDto.Response(1, "hgd@gmail.com", "홍길동", "user_password", "https://avatars.dicebear.com/api/bottts/222.svg");
//
//        given(memberService.findMember(Mockito.anyInt())).willReturn(member);
//        given(mapper.memberToMemberResponseDto(Mockito.any(Member.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/v1/member/{member-id}", memberId)
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andDo(document(
//                        "get-member",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("member-id").description("회원 식별자")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.image").type(JsonFieldType.STRING).description("이미지 주소")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void getMembersTest() throws Exception {
//
//        Member member1 = new Member();
//        member1.setMemberId(1);
//        member1.setEmail("hgd@gmail.com");
//        member1.setName("홍길동");
//        member1.setPassword("user_password1");
//        member1.setImage("https://avatars.dicebear.com/api/bottts/222.svg");
//
//        Member member2 = new Member();
//        member2.setMemberId(2);
//        member2.setEmail("agd@gmail.com");
//        member2.setName("김길동");
//        member2.setPassword("user_password2");
//        member2.setImage("https://avatars.dicebear.com/api/bottts/222.svg");
//
//        MemberDto.Response responseDto1 =
//                new MemberDto.Response(1, "hgd@gmail.com", "홍길동", "user_password1", "https://avatars.dicebear.com/api/bottts/222.svg");
//
//        MemberDto.Response responseDto2 =
//                new MemberDto.Response(2, "agd@gmail.com", "김길동", "user_password2", "https://avatars.dicebear.com/api/bottts/222.svg");
//
//        int page = 2;
//        int size = 10;
//
//        Page<Member> members = new PageImpl<>(List.of(member1, member2), PageRequest.of(page-1, size,
//                Sort.by("memberId").descending()), 2);
//
//        List<MemberDto.Response> responseDtos = List.of(responseDto1,responseDto2);
//
//        given(memberService.findMembers(Mockito.anyInt(), Mockito.anyInt())).willReturn(members);
//        given(mapper.membersToMemberResponseDto(Mockito.anyList())).willReturn(responseDtos);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/v1/member")
//                                .param("page", String.valueOf(page))
//                                .param("size", String.valueOf(size))
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//        // then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andDo(document(
//                        "get-members",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestParameters(
//                                parameterWithName("page").description("페이지"),
//                                parameterWithName("size").description("사이즈")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("data[].email").type(JsonFieldType.STRING).description("이메일"),
//                                        fieldWithPath("data[].name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data[].image").type(JsonFieldType.STRING).description("이미지 주소"),
//
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("페이지 요소 수"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
//
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void deleteMemberTest() throws Exception {
//        //given
//        int memberId = 1;
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                delete("/v1/member/{member-id}", memberId).accept(MediaType.APPLICATION_JSON));
//
//        //then
//        actions.andExpect(status().isNoContent())
//                .andDo(MockMvcRestDocumentation.document("delete-member",
//                        pathParameters(
//                                parameterWithName("member-id").description("멤버 식별자")
//                        )
//                ));
//    }
//}
