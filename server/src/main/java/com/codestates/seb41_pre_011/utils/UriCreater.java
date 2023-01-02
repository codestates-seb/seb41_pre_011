package com.codestates.seb41_pre_011.utils;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriCreater {
    public static URI createUri(String defaultUrl, int resourceId) {
        return UriComponentsBuilder
                .newInstance()
                .path(defaultUrl + "/{resource-id}")
                .buildAndExpand(resourceId)
                .toUri();
    }
}
