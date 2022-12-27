package com.codestates.seb41_pre_011.member.entity;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    private String image;

    @OneToMany
    private List<Question> questions = new ArrayList<>();

    @OneToMany
    private List<Answer> answers = new ArrayList<>();
}

