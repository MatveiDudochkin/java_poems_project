package com.irlix.poems;

import org.springframework.boot.SpringApplication;

public class TestPoemsApplication {

    public static void main(String[] args) {
        SpringApplication.from(PoemsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
