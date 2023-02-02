package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;

import KNU.Navibook.server.repository.BookInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class BookServiceTest {
    @Autowired BookService bookService;
    @Autowired BookInfoService bookInfoService;
    @Test
    public void saveBook(){
        //given
        Book book1 = new Book();

        book1.setId(10L);
        book1.setSelfFloor(2L);

        //when
        Book newbook = bookService.saveBook(book1);

        //then
        assertThat(newbook.getId()).isEqualTo(book1.getId());
    }

    @Test
    public void findBook(){
        //given
        Book book1 = new Book();
        Book book2 = new Book();
        BookInfo bookinfo = new BookInfo();

        book1.setId(10L);
        book2.setId(20L);
        bookinfo.setWriter("aaa");

        book1.setBookInfo(bookinfo);
        book2.setBookInfo(bookinfo);

        bookInfoService.save(bookinfo);
        bookService.saveBook(book1);
        bookService.saveBook(book2);


        //when
        List<Book> bookList = bookService.findBook(bookinfo);

        //then
        assertThat(bookList.size()).isEqualTo(2);
    }

    @Test
    public void findBooks(){
        //given
        Book book1 = new Book();
        book1.setId(10L);
        book1.setStatus(true);
        book1.setSelfFloor(3L);

        Book book2 = new Book();
        book2.setId(13L);
        book2.setStatus(true);
        book2.setSelfFloor(3L);

        bookService.saveBook(book1);
        bookService.saveBook(book2);

        //when
        List<Book> bookList = bookService.findBooks();

        //then
        assertThat(bookList.size()).isEqualTo(2); // findAll 검증 하는 법.
    }
}
