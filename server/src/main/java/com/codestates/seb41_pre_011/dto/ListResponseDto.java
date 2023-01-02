package com.codestates.seb41_pre_011.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ListResponseDto<T> {
    private List<T> data;
    public ListResponseDto(List<T> data) {
        this.data = data;
    }
}
