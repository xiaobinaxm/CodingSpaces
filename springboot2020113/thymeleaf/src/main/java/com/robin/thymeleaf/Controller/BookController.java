package com.robin.thymeleaf.Controller;

import com.robin.thymeleaf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/4 19:45
 */
@Controller
public class BookController {

    @GetMapping("/book")
    public String book(Model model){
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("三国演义");
            book.setAuthor("罗贯中");
            book.setPrice(30.00);
            books.add(book);
        }
        model.addAttribute("books", books);
        return "book";
    }
}
