package com.lgzarturo.GameVerseAPI;

import org.springframework.boot.SpringApplication;

public class TestGameVerseApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(GameVerseApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
