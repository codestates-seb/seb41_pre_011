package com.codestates.seb41_pre_011.question.entity;

import com.codestates.seb41_pre_011.member.entity.Member;
import com.codestates.seb41_pre_011.tag.entity.TagQuestion;
import lombok.AllArgsConstructor;
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

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member questionMember;
//    public void addMember(Member member) {this.questionMember = questionMember;}

    @OneToMany(mappedBy = "question")
    private List<TagQuestion> tagQuestions = new ArrayList<>();
    public void addTagQuestion(TagQuestion tagQuestion) {this.tagQuestions = tagQuestions;}
}