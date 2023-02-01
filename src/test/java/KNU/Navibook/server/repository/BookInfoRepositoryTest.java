package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import java.util.List;

@SpringBootTest
class BookInfoRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookInfoRepository bookInfoRepository;

    @Test
    public void 책정보전체조회(){
        List<BookInfo> bookInfos=bookInfoRepository.findAll();
        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    public void 책정보이름으로조회(){
        String bookname="A1";
        List<BookInfo> bookInfos=bookInfoRepository.findBybookName(bookname);
        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }

    @Test
    public void 책정보이름비슷한것으로조회(){
        String bookname="A";

        List<BookInfo> bookInfos=bookInfoRepository.findBybookNameContaining(bookname);
        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    public void 책정보랜덤으로조회(){
        int count1=1;
        int count2=2;
        int count3=10;
        List<BookInfo> bookInfos1=bookInfoRepository.findRandom(count1);
        List<BookInfo> bookInfos2=bookInfoRepository.findRandom(count2);
        List<BookInfo> bookInfos3=bookInfoRepository.findRandom(count3);
//        for(BookInfo bookInfo:bookInfos1){
//            System.out.println(bookInfo.getBookName());
//        }
//        for(BookInfo bookInfo:bookInfos2){
//            System.out.println(bookInfo.getBookName());
//        }
        for(BookInfo bookInfo:bookInfos3){
            System.out.println(bookInfo.getBookName());
        }

    }

}