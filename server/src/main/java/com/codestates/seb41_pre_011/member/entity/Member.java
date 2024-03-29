package com.codestates.seb41_pre_011.member.entity;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
//    @Column(nullable = false)
    private String email;
//    @Column(nullable = false)
    private String name;
//    @Column(nullable = false)
    @JsonIgnore
    @Column(length = 100, nullable = false)
    private String password;
    private String image;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @JsonBackReference
    private List<Answer> answers = new ArrayList<>();
}

