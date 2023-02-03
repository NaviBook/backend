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
//    {book_id: 12334,
//            book_info_id:3245,
//    }
    @PostMapping("/api/book/add")
    @ResponseBody
    public Book bookAdd(@RequestBody Map<String, Object> requestData) {
        Long bookId= (Long)requestData.get("bookId");
        Long bookInfoId= (Long)requestData.get("bookInfoId");

        System.out.println(bookId);
        System.out.println(bookInfoId);
        Book book = bookService.findOne(bookId);
        BookInfo bookinfo = bookInfoService.findOne(bookInfoId);

        book.setBookInfo(bookinfo);
        bookService.saveBook(book);

        return book;
    }
}
