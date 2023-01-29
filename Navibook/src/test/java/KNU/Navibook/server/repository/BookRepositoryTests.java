package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test public void testClass(){
        System.out.println("__________"+bookRepository.getClass().getName());
    }

    @Test
    public void testInsertBooks(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Book book = new Book();
            bookRepository.save(book);
        });
    }

    @Test
    public void 책전체조회(){
        testInsertBooks();
        List<Book> books=bookRepository.findAll();
        for(Book book:books){
            System.out.println(book.getId());
        }
    }

}