package KNU.Navibook.server.service;

import KNU.Navibook.server.repository.BookInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import KNU.Navibook.server.domain.BookInfo;

import java.util.*;

@Service
public class BookInfoService {
    @Autowired
    private BookInfoRepository bookInfoRepository;
    public List<BookInfo> findAll(){
        return bookInfoRepository.findAll();
    }

    public List<BookInfo> findByBookName(String name){
        return bookInfoRepository.findBybookName(name);
    }

    public BookInfo findOne(Long id){
        return bookInfoRepository.findByid(id);
    }

    public List<BookInfo> findByBookNameContaining(String search){
        return bookInfoRepository.findBybookNameContaining(search);
    }
    public List<BookInfo> findRandom(int count){
        return bookInfoRepository.findRandom(count);
    }
    public BookInfo save(BookInfo bookInfo){
        return bookInfoRepository.save(bookInfo);
    }
//
//    @Transactional
//    public void deleteByid(Long id){
//        bookInfoRepository.deleteByid(id);
//    }

}
