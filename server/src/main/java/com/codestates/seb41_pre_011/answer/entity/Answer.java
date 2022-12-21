package com.codestates.seb41_pre_011.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private int answerId;

    //@Column(columnDefinition = "TEXT")
    private String content;

    //@Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    //@Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedDate = LocalDateTime.now();

    private boolean adoption;

    private int memberId;


}
