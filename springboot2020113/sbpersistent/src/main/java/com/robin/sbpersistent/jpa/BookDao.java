package com.robin.sbpersistent.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/8 12:20
 */
public interface BookDao extends JpaRepository<Book,Integer> {

    //自定义方法
    @Query(value = "select * from book where id =(select max(id) from book)",nativeQuery = true)
    Book getMaxIdBook();


    @Query(value = "insert into boot(name,author) values(?,?)",nativeQuery = true)
    @Modifying
    @Transactional
    Book addBook(String name,String author);
}
