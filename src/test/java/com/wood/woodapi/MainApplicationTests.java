package com.wood.woodapi;

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
}
