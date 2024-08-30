package com.wood.woodapi;

import javafx.application.Application;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

/**
 * 主类（项目启动入口）
 *
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.wood.woodapi.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDubbo
public class WoodapiApplication {

    public static void main(String[] args) {
        System.setProperty("dubbo.meta.cache.filePath.meta", "C:\\Users\\24420\\.dubbo\\backend");
        System.setProperty("dubbo.mapping.cache.filePath.meta", "C:\\Users\\24420\\.dubbo\\backend");
        SpringApplication.run(WoodapiApplication.class, args);
    }

}
