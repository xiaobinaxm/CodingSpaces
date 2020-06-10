package com.robin.sbpersistent;

import com.robin.sbpersistent.bean.User;
import com.robin.sbpersistent.jpa.Book;
import com.robin.sbpersistent.jpa.BookDao;
import com.robin.sbpersistent.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SbpersistentApplicationTests {
/*
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("robin");
        user.setAddress("www.robin.com");
        userService.addUser(user);
    }


    @Test
    public void test1() {
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }


    @Test
    public void test2() {
        List<User> allUsers2 = userService.getAllUsers2();
        System.out.println(allUsers2);
    }
*/

/*
    //注意一下2个方法的使用，效果是一样的，使用不同，原理也不同
    @Autowired
    @Qualifier("jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Resource(name = "jdbcTemplateTwo")//该注解常常与@RunWith(SpringRunner.class)配合使用，该注解是java中的，非spring
    JdbcTemplate jdbcTemplateTwo;

    @Test
    public void test3(){
        List<User> users1 = jdbcTemplateOne.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(users1);

        List<User> users2 = jdbcTemplateTwo.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(users2);
    }
*/
/*
    @Autowired
    //@Resource//这个注解可以正常执行，其他不修改的前提下，说明是Autowired注解的问题，核心还是IDEA配置问题，修改Auotwired的检查级别
    UserMapper userMapper;

    @Test
    public void test4(){
        List<User> allUsers = userMapper.getAllUsers();
        System.out.println(allUsers);
    }
*/

    @Autowired
    BookDao bookDao;

    @Test
    public void test5(){
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        bookDao.save(book);
    }
    @Test
    public void test6(){
        Book book = new Book();
        book.setAuthor("robin");
        book.setName("www.robin.com");
        book.setId(1);
        bookDao.saveAndFlush(book);//这个是更新操作
    }

    @Test
    public void test7(){
        Book maxIdBook = bookDao.getMaxIdBook();
        System.out.println(maxIdBook);
    }
}
