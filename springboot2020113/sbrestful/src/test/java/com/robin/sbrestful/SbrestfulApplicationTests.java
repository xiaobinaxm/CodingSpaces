package com.robin.sbrestful;

import com.robin.sbrestful.devtools.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SbrestfulApplicationTests {


/*    @Autowired
    HelloService helloService;

    @Test
    void contextLoads() {
        String s = helloService.syaHello("hello java boy");
        System.out.println(s);
    }*/

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void test(){
        String robin = testRestTemplate.getForObject("/hello?name={1}", String.class, "robin");
        System.out.println(robin);

    }

}
