package com.robin.sbsecurityjson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/12 0:08
 */
@RestController
public class JsonController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security json!";
    }

}
