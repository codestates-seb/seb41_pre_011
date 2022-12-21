package com.codestates.seb41_pre_011.answer.controller;

import com.codestates.seb41_pre_011.answer.dto.AnswerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/v1/answer")
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer() {
        return ResponseEntity.created(URI.create("v1/answer/1")).build();
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchAnswer() {
        AnswerDto.Response response =
                new AnswerDto.Response(1, "해결 방안", LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getAnswer() {
        AnswerDto.Response response =
                new AnswerDto.Response(1, "해결 방안", LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity getAnswers() {
        AnswerDto.Response response1 =
                new AnswerDto.Response(1, "해결 방안", LocalDateTime.now(), LocalDateTime.now());
        AnswerDto.Response response2 =
                new AnswerDto.Response(2, "해결 방안2", LocalDateTime.now(), LocalDateTime.now());
        return ResponseEntity.ok(Arrays.asList(response1, response2));
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer() {
        return ResponseEntity.noContent().build();
    }
}
