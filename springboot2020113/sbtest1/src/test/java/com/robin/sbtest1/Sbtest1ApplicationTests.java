package com.robin.sbtest1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Sbtest1ApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    void contextLoads() {
        String robin = testRestTemplate.getForObject("/hello?name={1}", String.class, "robin");
        System.out.println(robin);
    }

}
