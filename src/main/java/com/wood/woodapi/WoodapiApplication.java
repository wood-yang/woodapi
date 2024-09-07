package com.wood.woodapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主类（项目启动入口）
 *
 */

@MapperScan("com.wood.woodapi.mapper")
@EnableDubbo
@SpringBootApplication
public class WoodapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WoodapiApplication.class, args);
    }
}
