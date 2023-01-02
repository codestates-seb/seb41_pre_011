package com.codestates.seb41_pre_011.tagTest;

//import com.codestates.seb41_pre_011.tag.controller.TagController;
//import com.codestates.seb41_pre_011.tag.dto.TagDto;
//import com.codestates.seb41_pre_011.tag.entity.Tag;
//import com.codestates.seb41_pre_011.tag.mapper.TagMapper;
//import com.codestates.seb41_pre_011.tag.service.TagService;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
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
//import static com.codestates.seb41_pre_011.util.ApiDocumentUtils.*;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@WebMvcTest(TagController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class tagTestApi {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private TagService tagService;
//    @MockBean
//    private TagMapper mapper;
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void postTagTest() throws Exception {
//        //given
//        TagDto.Post post = new TagDto.Post("java", "자바");
//        String content = gson.toJson(post);
//        TagDto.Response response = new TagDto.Response(1, "java", "자바", 0);
//        given(mapper.tagPostDtoToTag(Mockito.any(TagDto.Post.class))).willReturn(new Tag());
//        given(tagService.createTag(Mockito.any(Tag.class))).willReturn(new Tag());
//        given(mapper.tagToTagResponseDto(Mockito.any(Tag.class))).willReturn(response);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/v1/tag")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content));
//
//        //then
//        actions.andExpect(status().isCreated())
//                .andDo(document("post-tag",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("description").type(JsonFieldType.STRING).description("설명")
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.description").type(JsonFieldType.STRING).description("설명"),
//                                        fieldWithPath("data.count").type(JsonFieldType.NUMBER).description("카운트")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void patchTagTest() throws Exception {
//        //given
//        TagDto.Patch patch = new TagDto.Patch(1, "자바", 1);
//        String content = gson.toJson(patch);
//        TagDto.Response response = new TagDto.Response(1, "java", "자바", 1);
//
//        given(mapper.tagPatchDtoToTag(Mockito.any(TagDto.Patch.class))).willReturn(new Tag());
//        given(tagService.updateTag(Mockito.any(Tag.class))).willReturn(new Tag());
//        given(mapper.tagToTagResponseDto(Mockito.any(Tag.class))).willReturn(response);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        patch("/v1/tag/{tag-id}", 1)
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//        //then
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.tagId").value(patch.getTagId()))
//                .andExpect(jsonPath("$.data.description").value(patch.getDescription()))
//                .andExpect(jsonPath("$.data.count").value(patch.getCount()))
//                .andDo(document("patch-tag",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("tag-id").description("태그 식별자")
//                        ),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("tagId").type(JsonFieldType.NUMBER).description("태그 식별자").ignored(),
//                                        fieldWithPath("description").type(JsonFieldType.STRING).description("설명").optional(),
//                                        fieldWithPath("count").type(JsonFieldType.NUMBER).description("카운트").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.description").type(JsonFieldType.STRING).description("설명"),
//                                        fieldWithPath("data.count").type(JsonFieldType.NUMBER).description("카운트")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void getTagTest() throws Exception {
//        //given
//        int tagId = 1;
//        Tag tag = new Tag();
//        tag.setTagId(tagId);
//        tag.setName("java");
//        tag.setDescription("설명");
//        tag.setCount(0);
//
//        TagDto.Response response = new TagDto.Response(1, "java", "설명", 0);
//
//        given(tagService.findTag(Mockito.anyInt())).willReturn(tag);
//        given(mapper.tagToTagResponseDto(Mockito.any(Tag.class))).willReturn(response);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/v1/tag/{tag-id}", tagId)
//                        .accept(MediaType.APPLICATION_JSON));
//
//        // then
//        actions.andExpect(status().isOk())
//                .andDo(document("get-tag",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("tag-id").description("태그 식별자")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data.description").type(JsonFieldType.STRING).description("설명"),
//                                        fieldWithPath("data.count").type(JsonFieldType.NUMBER).description("카운트")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    public void getTagsTest() throws Exception {
//        //given
//        int tagId1 = 1;
//        Tag tag1 = new Tag();
//        tag1.setTagId(tagId1);
//        tag1.setName("java");
//        tag1.setDescription("설명1");
//        tag1.setCount(0);
//
//        int tagId2 = 2;
//        Tag tag2 = new Tag();
//        tag2.setTagId(tagId2);
//        tag2.setName("spring");
//        tag2.setDescription("설명2");
//        tag2.setCount(0);
//
//        TagDto.Response response1 = new TagDto.Response(1, "java", "설명1", 0);
//        TagDto.Response response2 = new TagDto.Response(2, "spring", "설명2", 0);
//
//        int page = 2;
//        int size = 10;
//
//        Page<Tag> tags = new PageImpl<>(List.of(tag1, tag2), PageRequest.of(page - 1, size,
//                Sort.by("tagId").descending()), 2);
//
//        List<TagDto.Response> responses = List.of(response1, response2);
//
//        given(tagService.findTags(Mockito.anyInt(), Mockito.anyInt())).willReturn(tags);
//        given(mapper.tagsToTagResponseDto(Mockito.anyList())).willReturn(responses);
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        get("/v1/tag")
//                                .param("page", String.valueOf(page))
//                                .param("size", String.valueOf(size))
//                                .accept(MediaType.APPLICATION_JSON)
//                );
//        //then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andDo(document(
//                        "get-tags",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestParameters(
//                                parameterWithName("page").description("페이지"),
//                                parameterWithName("size").description("사이즈")
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                        fieldWithPath("data[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data[].name").type(JsonFieldType.STRING).description("이름"),
//                                        fieldWithPath("data[].description").type(JsonFieldType.STRING).description("설명"),
//                                        fieldWithPath("data[].count").type(JsonFieldType.NUMBER).description("카운트"),
//
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 수"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("페이지 요소 수"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
//                                )
//                        )
//                ));
//    }
//    @Test
//    public void deleteTagTest() throws Exception {
//        //given
//        int tagId = 1;
//
//        //when
//        ResultActions actions = mockMvc.perform(
//                delete("/v1/tag/{tag-id}", tagId).accept(MediaType.APPLICATION_JSON));
//
//        //then
//        actions.andExpect(status().isNoContent())
//                .andDo(MockMvcRestDocumentation.document("delete-tag",
//                        pathParameters(
//                                parameterWithName("tag-id").description("태그 식별자")
//                        )
//                                )
//
//                );
//    }
//}
