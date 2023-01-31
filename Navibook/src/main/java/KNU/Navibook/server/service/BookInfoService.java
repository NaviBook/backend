package KNU.Navibook.server.service;

import KNU.Navibook.server.repository.BookInfoRepository;
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

    public List<BookInfo> findByBookNameContaining(String search){
        return bookInfoRepository.findBybookNameContaining(search);
    }
}