package com.codestates.seb41_pre_011.tag.entity;

import com.codestates.seb41_pre_011.question.entity.Question;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class TagQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagQuestionId;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
    public void addTag(Tag tag) {this.tag = tag;}

    @ManyToOne
    @JoinColumn(name = "Question_ID")
    private Question question;
}
