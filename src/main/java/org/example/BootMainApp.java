package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @Author: CZF
 * @Create: 2024/9/14 - 19:04
 */
@SpringBootApplication
@MapperScan({"org.example.mapper"})
public class BootMainApp {

    public static void main(String[] args) {
        SpringApplication.run(BootMainApp.class, args);
    }

}
