package KNU.Navibook.server.controller;


import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookInfoService;
import KNU.Navibook.server.service.BookService;
import KNU.Navibook.server.service.BookShelfService;
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
    @Autowired
    BookShelfService bookShelfService;

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

//        1. 이미 존재하는 book_id 값이라면 등록 거부(오류 메시지)
//        2. bookinfo_id 값이 존재하지 않으면 등록 거부
    @PostMapping("/api/book/add")
    @ResponseBody
    public Book bookAdd(@RequestBody Map<String, Object> requestData) {
        Integer tmp1 = (Integer) requestData.get("bookId"); // Long으로 한 번에 못 받아옴
        Integer tmp2 = (Integer) requestData.get("bookInfoId");
        Long bookId = tmp1.longValue();
        Long bookInfoId = tmp2.longValue();


        Book book = new Book();
        book.setId(bookId);

        BookInfo bookinfo = bookInfoService.findOne(bookInfoId);
        book.setBookInfo(bookinfo);

        bookService.saveBook(book);

        return book;
    }

    @PostMapping("/api/book/delete") // 없는 값 삭제하면 badgate
    @ResponseBody
    public void bookDelete(@RequestBody Book book){
        bookService.deleteBook(book.getId());
    }

    //bookid에 맞는 book 없으면 오류
    //bookshelfid에 맞는 bookshelf 없으면 오류
    @PostMapping("/api/book/position")
    @ResponseBody
    public Book bookAddPosition(@RequestBody Map<String, Object> requestData) {
        Integer tmp1 = (Integer) requestData.get("bookId"); // Long으로 한 번에 못 받아옴
        Integer tmp2 = (Integer) requestData.get("bookShelfId");
        Integer tmp3 = (Integer) requestData.get("selfFloor");
        Long bookId = tmp1.longValue();
        Long bookShelfId = tmp2.longValue();
        Long selfFloor = tmp3.longValue();


        Book book=bookService.findOne(bookId);
        BookShelf bookShelf = bookShelfService.findOne(bookShelfId);
        book.setBookShelf(bookShelf);
        book.setSelfFloor(selfFloor);

        bookService.saveBook(book);

        return book;
    }

}
