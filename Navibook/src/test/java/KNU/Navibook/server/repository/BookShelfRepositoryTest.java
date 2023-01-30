package KNU.Navibook.server.repository;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.domain.BookShelf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookShelfRepositoryTest {
    @Autowired
    BookShelfRepository bookShelfRepository;

    @Test
    public void 책장전체조회(){
        List<BookShelf> bookShelves=bookShelfRepository.findAll();
        for(BookShelf bookShelf:bookShelves){
            System.out.println(bookShelf.getId());
        }
    }
    @Test
    public void 책장층별조회(){
        String floor="1F";
        List<BookShelf> bookShelves=bookShelfRepository.findBylibraryFloor(floor);
        for(BookShelf bookShelf:bookShelves){
            System.out.println(bookShelf.getHeight());
        }
    }
}
