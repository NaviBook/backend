package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bookshelf")
@Controller
public class BookShelfController {
    @Autowired
    BookShelfService bookShelfService;


    @GetMapping("")
    @ResponseBody
    public List<BookShelf> returnAll(){
        return bookShelfService.findAll();
    }
    @GetMapping("/{libraryFloor}")
    @ResponseBody
    public List<BookShelf> returnAllBookShelfs(@PathVariable("libraryFloor") String floor){
        return bookShelfService.findByLibraryFloor(floor);
    }


    @PostMapping("/add")
    @ResponseBody
    public BookShelf save(@RequestBody BookShelf bookShelf){
        return bookShelfService.save(bookShelf);
    }

}
