package com.codestates.seb41_pre_011.answer.controller;

import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.mapper.AnswerMapper;
import com.codestates.seb41_pre_011.answer.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/answer")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post requestbody) {
        Answer answer = answerMapper.answerPostDtoToAnswer(requestbody);
        Answer createdAnswer = answerService.createAnswer(answer);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(createdAnswer);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive int answerId,
                                      @RequestBody AnswerDto.Patch requestbody) {
        requestbody.setAnswerId(answerId);
        Answer updateAnswer = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(requestbody));
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(updateAnswer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive int answerId) {
        Answer findAnswer = answerService.findAnswer(answerId);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(findAnswer);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers() {
        List<Answer> answers = answerService.findAnswers();
        List<AnswerDto.Response> response = answers.stream().map(answer -> answerMapper.answerToAnswerResponseDto(answer))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive int answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
