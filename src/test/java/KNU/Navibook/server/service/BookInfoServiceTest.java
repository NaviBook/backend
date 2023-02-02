package KNU.Navibook.server.service;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import java.util.List;
@SpringBootTest
public class BookInfoServiceTest {
    @Autowired
    BookInfoService bookInfoService;

    @Test
    public void 책정보전체조회(){
        List<BookInfo> bookInfos=bookInfoService.findAll();

        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    public void 책정보이름으로조회(){
        String name= "A10";
        List<BookInfo> bookInfos=bookInfoService.findByBookName(name);

        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    public void 책정보비슷한이름으로조회(){
        String search= "A";
        List<BookInfo> bookInfos=bookInfoService.findByBookNameContaining(search);

        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    public void 책정보랜덤조회(){
        int count2=2;

        List<BookInfo> bookInfos1=bookInfoService.findRandom(count2);

        for(BookInfo bookInfo:bookInfos1){
            System.out.println(bookInfo.getBookName());
        }
    }
    @Test
    @Transactional
    public BookInfo 책정보등록(){
        String bookname="test";
        String writer="daesung";

        BookInfo bookInfo=new BookInfo();

        bookInfo.setBookName(bookname);
        bookInfo.setWriter(writer);

        BookInfo savebookInfo;
        savebookInfo=bookInfoService.save(bookInfo);

        System.out.println(savebookInfo.getId());
        return savebookInfo;
    }
//    @Test
//    @Transactional
//    public void 책정보삭제(){
//        BookInfo newbook=책정보등록();
//        Long id= newbook.getId();
//        책정보전체조회();
//        bookInfoService.deleteByid(id);
//        책정보전체조회();
//    }
}
