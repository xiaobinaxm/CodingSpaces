package com.robin.sbsecurity03dy.service;

import com.robin.sbsecurity03dy.bean.Menu;
import com.robin.sbsecurity03dy.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/11 10:06
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
