package com.javaclimb.itmusic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.javaclimb.itmusic.dao")
@SpringBootApplication
public class ITmusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ITmusicApplication.class, args);
    }

}
