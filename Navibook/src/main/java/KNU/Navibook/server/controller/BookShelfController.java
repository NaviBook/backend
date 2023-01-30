package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/api/bookShelf")
@Controller
public class BookShelfController {
    @Autowired
    BookShelfService bookShelfService;

    @GetMapping("/returnAllBookShelfs/{libraryFloor}")
    @ResponseBody
    public List<BookShelf> returnAllBookShelfs(@PathVariable("libraryFloor") String floor){
        return bookShelfService.findByLibraryFloor(floor);
    }
}
