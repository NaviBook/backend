package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.standard.expression.Each;

import java.util.stream.IntStream;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional //테스트 끝난 후 롤백
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookInfoRepository bookInfoRepository;

    @Test
    public void 책저장테스트() {
        //given
        Book book1 = new Book();
        Book book2 = new Book();

        book1.setId(151L);
        book1.setStatus(true);
        book1.setSelfFloor(1L);

        book2.setId(121321L);
        book2.setStatus(true);
        book2.setSelfFloor(2L);
        bookRepository.save(book1);
        bookRepository.save(book2);

        //when
        Long testId1 = bookRepository.findById(book1.getId()).get().getId();
        Long testId2 = bookRepository.findById(book2.getId()).get().getId();


        //then
        assertThat(book1.getId()).isEqualTo(testId1);
        assertThat(book2.getId()).isEqualTo(testId2);
    }
    @Test
    public void 책과책인포의관계테스트 () {
        //given
        BookInfo bookinfo = new BookInfo();

        bookinfo.setBookName("A1");
        bookinfo.setWriter("조대성");
        bookInfoRepository.save(bookinfo);

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setId(121L);
        book2.setId(1215L);
        book1.setStatus(true);
        book1.setSelfFloor(1L);
        book2.setStatus(true);
        book2.setSelfFloor(2L);
        book1.setBookInfo(bookinfo);
        book2.setBookInfo(bookinfo);

        bookRepository.save(book1);
        bookRepository.save(book2);

        //when
        BookInfo test1 = bookRepository.findByid(book1.getId()).getBookInfo();
        BookInfo test2 = bookRepository.findByid(book2.getId()).getBookInfo();

        //then
        assertThat(test1).isEqualTo(test2);
        assertThat(test1).isEqualTo(bookinfo);
    }

    @Test
    public void bookinfo로book찾기(){
        BookInfo bookinfo = new BookInfo();
        bookinfo.setBookName("hey");
        bookinfo.setWriter("yol");
        bookInfoRepository.save(bookinfo);

        Book book1 = new Book();
        Book book2 = new Book();

        book1.setId(3L);
        book1.setStatus(false);
        book1.setSelfFloor(10L);

        book2.setId(10L);
        book2.setStatus(true);
        book2.setSelfFloor(30L);

        book1.setBookInfo(bookinfo);
        book2.setBookInfo(bookinfo);

        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> booklist = bookRepository.findBybookInfo(bookinfo);

        assertThat(booklist.get(0).getBookInfo()).isEqualTo(bookinfo);
        assertThat(booklist.get(1).getBookInfo()).isEqualTo(bookinfo);
    }
}





