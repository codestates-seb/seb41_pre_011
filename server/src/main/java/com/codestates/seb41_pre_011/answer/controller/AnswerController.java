package com.codestates.seb41_pre_011.answer.controller;

import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.answer.mapper.AnswerMapper;
import com.codestates.seb41_pre_011.answer.service.AnswerService;
import com.codestates.seb41_pre_011.dto.MultiResponseDto;
import com.codestates.seb41_pre_011.dto.SingleResponseDto;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/answer")
@Validated
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.Post requestBody) {
        Answer answer = answerMapper.answerPostDtoToAnswer(requestBody);
        Answer createdAnswer = answerService.createAnswer(answer);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(createdAnswer);
        return new ResponseEntity<>(new SingleResponseDto(response),HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive int answerId,
                                      @Valid @RequestBody AnswerDto.Patch requestBody) {
        requestBody.setAnswerId(answerId);
        Answer updateAnswer = answerService.updateAnswer(answerMapper.answerPatchDtoToAnswer(requestBody));
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(updateAnswer);
        return new ResponseEntity<>(new SingleResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswer(@PathVariable("answer-id") @Positive int answerId) {
        Answer findAnswer = answerService.findAnswer(answerId);
        AnswerDto.Response response = answerMapper.answerToAnswerResponseDto(findAnswer);
        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@RequestParam int page,
                                     @RequestParam int size) {
        Page<Answer> pageAnswers = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswers.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(answerMapper.answersToAnswerResponseDto(answers),
                        pageAnswers), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive int answerId) {
        answerService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}