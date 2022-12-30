package com.codestates.seb41_pre_011.helper;

import com.codestates.seb41_pre_011.tag.entity.Tag;

public class TagCalculator {
    public static int calculateTagCount(int nowCount, int earned) {return nowCount + earned;}

    public static int CalculateEarnedTagCount(Tag tag) {
        return tag.getTagQuestions().stream()
                .map(tagQuestion -> tagQuestion.getTagCount())
                .mapToInt(tagCount -> tagCount)
                .sum();
    }
}
