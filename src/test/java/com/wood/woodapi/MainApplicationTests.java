package com.wood.woodapi;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * 主类测试
 *
 *
 */
@SpringBootTest
class MainApplicationTests {
    @Test
    void contextLoads() {
        String encryptPassword = DigestUtils.md5DigestAsHex(("wood12345678").getBytes());
        System.out.println(encryptPassword);
    }

    @Test
    void test() throws NacosException {
        String serverAddr = "localhost:8848";

        ConfigService configService = NacosFactory.createConfigService(serverAddr);

        NamingService namingService = NacosFactory.createNamingService(serverAddr);
    }
}
