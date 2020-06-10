package com.robin.sbrestful.devtools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 14:28
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class justTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test(){
        String robin = testRestTemplate.getForObject("/hello?name={1}", String.class, "robin");
        System.out.println(robin);

    }
}











