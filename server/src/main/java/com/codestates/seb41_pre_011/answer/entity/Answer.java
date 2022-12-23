package com.codestates.seb41_pre_011.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    @Column(nullable = false)
    private String content;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate = LocalDateTime.now();
    private boolean adoption;
    private int memberId;
}
