package com.robin.sbsecurity03dy;

import com.robin.sbsecurity03dy.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sbsecurity03DyApplicationTests {

    @Autowired
    MenuService menuService;

    @Test
    void test() {
        System.out.println(menuService.getAllMenus());
    }

}
