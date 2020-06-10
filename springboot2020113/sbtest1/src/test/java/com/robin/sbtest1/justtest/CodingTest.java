package com.robin.sbtest1.justtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/9 15:20
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CodingTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test(){
        RestTemplate restTemplate = testRestTemplate.getRestTemplate();
        System.out.println(restTemplate.toString());

        String forObject = testRestTemplate.getForObject("/hello?name={1}", String.class, ">>>>hello just test");
        System.out.println(forObject);

    }
}
