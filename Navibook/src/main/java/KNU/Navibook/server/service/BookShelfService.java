package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import KNU.Navibook.server.repository.BookShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShelfService {
    @Autowired
    private BookShelfRepository bookShelfRepository;

    public List<BookShelf> findAll(){
        return bookShelfRepository.findAll();
    }
    public List<BookShelf> findByLibraryFloor(String floor){
        return bookShelfRepository.findBylibraryFloor(floor);
    }
}
