package com.codestates.seb41_pre_011.tag.entity;

import com.codestates.seb41_pre_011.question.entity.TagQuestion;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;
    @Column(nullable = false, updatable = false, unique = true)
    private String name;
    @Column(length = 255, nullable = false)
    private String description;
    private int count;

    @OneToMany(mappedBy = "tag")
    private List<TagQuestion> tagQuestions = new ArrayList<>();
    public void addTagQuestion(TagQuestion tagQuestion) {this.tagQuestions.add(tagQuestion);
    if(tagQuestion.getTag() != this) {tagQuestion.addTag(this);}
    }

    @OneToMany(mappedBy = "tag")
    private List<TagAnswer> tagAnswers = new ArrayList<>();
}
