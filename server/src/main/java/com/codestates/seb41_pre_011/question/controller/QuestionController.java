package com.codestates.seb41_pre_011.question.controller;

import com.codestates.seb41_pre_011.dto.MultiResponseDto;
import com.codestates.seb41_pre_011.dto.SingleResponseDto;
import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.question.mapper.QuestionMapper;
import com.codestates.seb41_pre_011.question.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/question")
@Validated
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;


    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody){
        Question question = mapper.questionPostToQuestion(requestBody);

        Member member = new Member();
        member.setName("김코딩");
        member.setImage("https://avatars.dicebear.com/api/bottts/151.svg");
        question.setMember(member);
        Question createdQuestion = questionService.createQuestion(question);
        QuestionDto.Response response = mapper.questionToQuestionResponse(createdQuestion);
        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") int questionId,
                                        @Valid @RequestBody QuestionDto.Patch requestBody){
        requestBody.setQuestionId(questionId);
        Question question = mapper.questionPatchToQuestion(requestBody);
        Question updateQuestion = questionService.updateQuestion(question);
        QuestionDto.Response response = mapper.questionToQuestionResponse(updateQuestion);
        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") int questionId){
        Question question = questionService.findQuestion(questionId);
        QuestionDto.Response response = mapper.questionToQuestionResponse(question);
        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@RequestParam int page,
                                       @RequestParam int size){
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);
        List<Question> responses = pageQuestions.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionsToQuestionResponses(responses),
                pageQuestions), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") int questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}


//    @GetMapping
//    public ResponseEntity getMembers(@RequestParam int page,
//                                     @RequestParam int size) {
//        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
//        List<Member> members = pageMembers.getContent();
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(memberMapper.membersToMemberResponseDto(members),
//                        pageMembers),
//                HttpStatus.OK);
//    }