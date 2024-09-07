package com.wood.woodapi;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 主类测试
 *
 *
 */
@SpringBootTest
class MainApplicationTests {

    @Test
    void contextLoads() {
        String result = HttpUtil.get("http://localhost:8091/api/name/test");
//        HttpResponse response = HttpRequest.get("http://localhost:8091/api/name/test").
//                execute();
        System.out.println(result);
    }
}
