package com.codestates.seb41_pre_011.tag.entity;

import com.codestates.seb41_pre_011.answer.entity.Answer;
import com.codestates.seb41_pre_011.tag.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class TagAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagAnswer;
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
    public void addTag(Tag tag) {this.tag = tag;}

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;
}
