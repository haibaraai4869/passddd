package com.qys.filetransfer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan(basePackages = "com.qys.filetransfer.mapper")
@SpringBootApplication
public class FiletransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiletransferApplication.class, args);
    }

}
