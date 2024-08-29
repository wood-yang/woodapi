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
        // 创建SpringApplication实例
        SpringApplication application = new SpringApplication(Application.class);
        // 添加自定义的ApplicationContextInitializer
        application.addInitializers(context -> {
            // 获取Environment对象
            Environment env = context.getEnvironment();
            // 从Environment中读取"spring.application.name"属性值
//            String appName = env.getProperty("spring.application.name");
            String appName = "woodapi";
            String filePath = System.getProperty("user.home") + File.separator + ".dubbo" + File.separator + appName;
            // 修改dubbo的本地缓存路径，避免缓存冲突
            System.setProperty("dubbo.meta.cache.filePath.meta", filePath);
            System.setProperty("dubbo.mapping.cache.filePath.mapping", filePath);
        });
        // 启动应用
//        SpringApplication.run(application.getClass(), args);
//        application.run(WoodapiApplication.class, args);
        SpringApplication.run(WoodapiApplication.class, args);
    }

}
