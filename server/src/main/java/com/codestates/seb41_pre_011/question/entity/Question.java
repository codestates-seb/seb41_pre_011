package com.codestates.seb41_pre_011.question.entity;

import com.codestates.seb41_pre_011.answer.entity.Answer;

import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.question.dto.TagQuestionResponseDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String questionContent;
    @Column(nullable = false)
    private String attemptContent;
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @Column(nullable = false)
    private LocalDateTime modifiedDate;
    @ElementCollection
    private List<TagQuestionResponseDto> tags;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<TagQuestion> tagQuestions = new ArrayList<>();
}