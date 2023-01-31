package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookInfoRepository bookInfoRepository;

    @Test
    public void 책저장테스트() {
        Book book1 = new Book();
        Book book2 = new Book();

        book1.setStatus(true);
        book1.setSelfFloor(1L);

        book2.setStatus(true);
        book2.setSelfFloor(2L);
        bookRepository.save(book1);
        bookRepository.save(book2);

        Long testId1 = bookRepository.findById(book1.getId()).get().getId();
        Long testId2 = bookRepository.findById(book2.getId()).get().getId();

        assertThat(book1.getId()).isEqualTo(testId1);
        assertThat(book2.getId()).isEqualTo(testId2);
    }
    @Test
    public void 책과책인포의관계테스트 () {
        BookInfo bookinfo = new BookInfo();

        bookinfo.setBookName("A1");
        bookinfo.setWriter("조대성");
        bookInfoRepository.save(bookinfo);

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setStatus(true);
        book1.setSelfFloor(1L);
        book2.setStatus(true);
        book2.setSelfFloor(2L);
        bookRepository.save(book1);
        bookRepository.save(book2);

        book1.setBookInfo(bookinfo);
        book2.setBookInfo(bookinfo);

    }
}





