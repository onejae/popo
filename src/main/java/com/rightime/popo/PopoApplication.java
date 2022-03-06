package com.rightime.popo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class PopoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PopoApplication.class, args);
    }
}
