package com.robin;

import com.alibaba.druid.sql.SQLUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.robin.mapper.UserMapper;
import com.robin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@SpringBootTest
class MybatisPlusSpringbootApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        //参数是一个wrapper，条件构造器，这里不用使用null即可
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void test1() {
        User user = new User();
        user.setName("Robin");
        user.setAge(18);
        user.setEmail("robin@163.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }


    @Test
    public void test2() {
        User user = new User();
        user.setId(6L);
        user.setAge(18);
        user.setName("Robin");
        //注意：updateById 但是参数是一个对象
        int i = userMapper.updateById(user);
        System.out.println(i);
        System.out.println(user);
    }


    @Test
    //测试乐观锁
    public void test3() {
        //查询用户信息
        User user = userMapper.selectById(6L);

        //修改用户信息
        user.setAge(888);
        user.setName("Robinnnnn");
        //执行用户更新操作
        int i = userMapper.updateById(user);
        System.out.println(i);
        System.out.println(user.toString());

    }


    //测试分页
    @Test
    public void test4() {
        //第一个参数：当前页
        //第二个参数：页面大小
        Page<User> page = new Page<>(1,3);//仅仅支持3.3.0版本
//        Page<User> userPage = userMapper.selectPage(page, null);
//        userPage.getRecords().forEach(System.out::println);
    }


    //测试逻辑删除
    @Test
    public void test5() {
        int i = userMapper.deleteById(1253981059511521282L);
        System.out.println(i);
    }

///////////////////////////wrapper测试///////////////////////////////////////


    @Test
    public void test6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name")
                .ge("age", 18);
        userMapper.selectList(queryWrapper).forEach(System.out::println);

    }


    @Test
    public void test7() {
        String property = System.getProperty("user.dir");
        System.out.println(property);

        String property1 = System.getProperty("os.version");
        System.out.println(property1);

        String property2 = System.getProperty("os.name");
        System.out.println(property2);

        String property3 = System.getProperty("java.version");
        System.out.println(property3);
    }

    /////////////////////Swagger2//////////////////////////
    @Test
    public void test8() {
        Profiles profiles = Profiles.of("dev");
       DocumentationType documentationType;
       Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.robin...."))
                //.paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("", "", "");
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0", "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}























