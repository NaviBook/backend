package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import KNU.Navibook.server.domain.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBook(BookInfo bookInfo){ // BookInfoId로 책 검색
        return bookRepository.findBybookInfo(bookInfo);
    }

    public List<Book> findBooks(){  //모든 book 조회
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book findOne(Long bookId){
        return bookRepository.findByid(bookId);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
}
