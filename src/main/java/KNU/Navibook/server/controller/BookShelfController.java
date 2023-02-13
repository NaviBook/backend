package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PostMapping("/edit")
    @ResponseBody
    public String edit(@RequestBody BookShelf bookShelf){
        if (bookShelfService.validateDuplicateBookShelf(bookShelf)==-1){
            return "id중복";
        }
        bookShelfService.save(bookShelf);
        return "success";
    }

}
