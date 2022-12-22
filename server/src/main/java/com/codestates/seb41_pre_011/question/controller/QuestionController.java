package com.codestates.seb41_pre_011.question.controller;

import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.question.mapper.QuestionMapper;
import com.codestates.seb41_pre_011.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Post requestBody){
        Question question = mapper.questionPostToQuestion(requestBody);
        Question createdQuestion = questionService.createQuestion(question);
        QuestionDto.Response response = mapper.questionToQuestionResponse(createdQuestion);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") int questionId,
                                        @RequestBody QuestionDto.Patch requestBody){
        Question question = mapper.questionPatchToQuestion(requestBody);
        Question updateQuestion = questionService.updateQuestion(question);
        QuestionDto.Response response = mapper.questionToQuestionResponse(updateQuestion);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") int questionId){
        Question question = questionService.findQuestion(questionId);
        QuestionDto.Response response = mapper.questionToQuestionResponse(question);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(){
        List<Question> questions = questionService.findQuestions();
        List<QuestionDto.Response> response = questions
                .stream()
                .map(question -> mapper.questionToQuestionResponse(question))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") int questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
