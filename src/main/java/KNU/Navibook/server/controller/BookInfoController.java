package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bookinfo")
@Controller
public class BookInfoController {
    @Autowired
    BookInfoService bookInfoService;
    @GetMapping("")
    @ResponseBody
    public List<BookInfo> returnBookInfo(){
        return bookInfoService.findAll();
    }
    @GetMapping("/{bookName}")
    @ResponseBody
    public List<BookInfo> returnBookInfo(@PathVariable("bookName") String name){
        return bookInfoService.findByBookNameContaining(name);
    }

    @GetMapping("/random/{count}")
    @ResponseBody
    public List<BookInfo> returnBookInfoRandom(@PathVariable("count") int count){
        return bookInfoService.findRandom(count);
    }

    @PostMapping ("/add")
    @ResponseBody
    public BookInfo bookInfoSave(@RequestBody BookInfo bookInfo){
        return bookInfoService.save(bookInfo);
    }

}
