package com.codestates.seb41_pre_011;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serverTestController {
    @GetMapping
    public String serverTest() {
        String abc = "1석 11조 통신 테스트";
        return abc;
    }
}
