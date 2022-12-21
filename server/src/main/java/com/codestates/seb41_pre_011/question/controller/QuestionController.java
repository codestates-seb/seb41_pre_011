package com.codestates.seb41_pre_011.question.controller;

import com.codestates.seb41_pre_011.question.dto.QuestionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
        @PostMapping
        public ResponseEntity postQuestion(){
            return ResponseEntity.created(URI.create("v1/question/1")).build();
        }@PatchMapping("/{question-id}")
        public ResponseEntity patchQuestion(){
            QuestionDto.Response response =
                    new QuestionDto.Response(1, "자바 질문", "자바를 모르겠습니다.","시도했습니다", LocalDateTime.now(),LocalDateTime.now(),"홍길동", List.of(new String[]{"java", "spring"}),2);
            return ResponseEntity.ok(response);
        }
        @GetMapping("/{question-id}")
        public ResponseEntity getQuestion(){
        QuestionDto.Response response =
                new QuestionDto.Response(1, "자바 질문", "자바를 모르겠습니다.","시도했습니다", LocalDateTime.now(),LocalDateTime.now(),"홍길동",List.of(new String[]{"java", "spring"}),2);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity getQuestions(){
        QuestionDto.Response response1 =
                new QuestionDto.Response(1, "자바 질문", "자바를 모르겠습니다.","시도했습니다", LocalDateTime.now(),LocalDateTime.now(),"홍길동",List.of(new String[]{"java", "spring"}),2);
        QuestionDto.Response response2 =
                new QuestionDto.Response(2, "스프링 질문", "스프링을 모르겠습니다.","고쳤습니다", LocalDateTime.now(),LocalDateTime.now(),"김길동",List.of(new String[]{"python", "django"}),4);
        return ResponseEntity.ok(Arrays.asList(response1,response2));
    }
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(){
        return ResponseEntity.noContent().build();
    }
}
