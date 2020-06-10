package com.robin.sbrestful;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/8 17:49
 */
public interface BookDao extends JpaRepository<Book,Integer> {

    List<Book> findBooksByNameContaining(@Param("name") String name);


}
