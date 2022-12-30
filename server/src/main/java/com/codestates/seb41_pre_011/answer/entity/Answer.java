package com.codestates.seb41_pre_011.answer.entity;

import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.tag.entity.TagAnswer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private int questionId;
    @ElementCollection
    private List<String> tags;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    @JsonBackReference
    private Member member;

    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;

    @OneToMany(mappedBy = "answer")
    private List<TagAnswer> tagAnswers = new ArrayList<>();
}