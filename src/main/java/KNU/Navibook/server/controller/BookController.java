package KNU.Navibook.server.controller;


import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookInfoService;
import KNU.Navibook.server.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import KNU.Navibook.server.domain.Book;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/test")
    @ResponseBody
    public Book bookSave(@RequestBody Book book) {
        System.out.println(book.getBookInfo().getBookName());
        System.out.println(book.getId());
        return book;
    }
    @PostMapping("/api/book/add")
    @ResponseBody
    public String bookAdd(@RequestBody Map<String, Object> requestData){
        Integer bookId = (Integer) requestData.get("bookId");
        Integer bookInfoId = (Integer) requestData.get("bookInfoId");

        System.out.println(bookId);
        System.out.println(bookInfoId);

        return "test";
    }
//        Book book = new Book();
//        BookInfo bookinfo = bookInfoService.findOne(bookInfoId);
//
//        book.setId(bookId);
//
//        //bookService.findOne(bookId);
//        book.setBookInfo(bookinfo);
//        bookService.saveBook(book);
//
//        return book;

}
