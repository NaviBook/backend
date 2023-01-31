package KNU.Navibook.server.controller;


import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookInfoService;
import KNU.Navibook.server.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import KNU.Navibook.server.domain.Book;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookInfoService bookInfoService;

    @GetMapping("/api/book") // book전체 조회
    @ResponseBody
    public List<Book> bookAll() {
        return bookService.findBooks();
    }

    @GetMapping("/api/book/{bookInfo}") // bookInfoId로 book조회
    @ResponseBody
    public List<Book> bookSearch(@PathVariable("bookInfo") Long infoId){
        return bookService.findBook(bookInfoService.findOne(infoId));
    }
}
