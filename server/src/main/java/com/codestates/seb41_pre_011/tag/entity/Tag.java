package com.codestates.seb41_pre_011.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
