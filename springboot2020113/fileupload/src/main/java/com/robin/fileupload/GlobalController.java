package com.robin.fileupload;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/6 11:27
 */
@RestController
public class GlobalController {

    @GetMapping("/global")
    public String global(Model model){
        Map<String, Object> map = model.asMap();
        Set<String> keyMap = map.keySet();

        for (String key : keyMap){
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("kkkkkkkkkkk");
        return "global";
    }
}
