package com.caomu.demo;

import com.caomu.bootstrap.annotation.CommonWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author 刘斌
 */
@SpringBootApplication
@CommonWeb
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
