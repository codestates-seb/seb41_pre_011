package com.codestates.seb41_pre_011;

import com.codestates.seb41_pre_011.member.controller.MemberController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Seb41Pre011Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Seb41Pre011Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(MemberController.class);
	}
}
