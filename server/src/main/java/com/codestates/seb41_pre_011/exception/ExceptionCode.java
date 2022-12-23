package com.codestates.seb41_pre_011.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "유저가 존재하지 않습니다."),
    MEMBER_EXISTS(409, "유저가 이미 존재합니다."),
    QUESTION_NOT_FOUND(404, "질문이 존재하지 않습니다."),
    MEMBER_UNAUTHORIZED(403, "권한이 없는 유저입니다."),
    ANSWER_NOT_FOUND(404,"답변이 존재하지 않습니다."),
    TAG_NOT_FOUND(404, "태그를 찾을 수 없습니다.")
    ;
    private final int status;
    private final String message;

    ExceptionCode(int httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }
}