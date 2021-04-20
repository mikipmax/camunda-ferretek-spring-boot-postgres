package com.ferretek;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FerretekApplication {

    public static void main(String[] args) {
        SpringApplication.run(FerretekApplication.class, args);
    }

}
