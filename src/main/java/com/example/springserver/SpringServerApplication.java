package com.example.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringServerApplication {

    public static void main(String[] args) {
        System.out.print("Hi");
        SpringApplication.run(SpringServerApplication.class, args);
    }

}
