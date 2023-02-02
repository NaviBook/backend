package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.BookShelf;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookShelfServiceTest {
    @Autowired
    BookShelfService bookShelfService;

    @Test
    public void 책장전체조회(){
        List<BookShelf> bookShelves=bookShelfService.findAll();
        for(BookShelf bookShelf:bookShelves){
            System.out.println(bookShelf.getId());
        }
    }

    @Test
    public void 층별책장조회(){
        String floor="1F";
        List<BookShelf> bookShelves=bookShelfService.findByLibraryFloor(floor);
        for (BookShelf bookShelf:bookShelves){
            System.out.println(bookShelf.getId());
        }
    }
    @Test
    @Transactional
    public void 책장등록(){
        Long id=1513L;
        Long shelfFloor=4L;
        Long positionX=20L;
        Long positionY=20L;
        Long height=100L;
        Long width=50L;
        String libraryFloor="2F";
        BookShelf bookShelf=new BookShelf(id,shelfFloor,positionX,positionY,width,height,libraryFloor);
        BookShelf savebookShelf=bookShelfService.save(bookShelf);
        System.out.println(savebookShelf.getId());
    }
}
