package KNU.Navibook.server.service;

import KNU.Navibook.server.domain.BookInfo;
import KNU.Navibook.server.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import KNU.Navibook.server.domain.Book;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBook(Long bookInfo){ // BookInfoId로 책 검색
        return bookRepository.findBybookInfo(bookInfo);
    }

    public List<Book> findBooks(){  //모든 book 조회
        return bookRepository.findAll();
    }
}
