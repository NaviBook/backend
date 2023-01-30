package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/api/bookinfo")
@Controller
public class BookInfoController {
    @Autowired
    BookInfoService bookInfoService;

    @GetMapping("/returnAllBookInfos")
    @ResponseBody
    public List<BookInfo> example() {
        return bookInfoService.findAll(); //스프링이 자동으로 JSON타입으로 객체를 반환해서 전달한다.
    }
    @GetMapping("/searchbookinfo")
    @ResponseBody
    public List<BookInfo> searchBookInfoByName(@RequestParam("bookName") String name) {
        System.out.println(name);
        return bookInfoService.findByBookNameContaining(name); //스프링이 자동으로 JSON타입으로 객체를 반환해서 전달한다.
    }
}
