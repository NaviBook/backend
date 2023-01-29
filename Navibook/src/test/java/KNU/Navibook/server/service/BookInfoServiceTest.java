package KNU.Navibook.server.service;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
            System.out.println(bookInfo.getBookname());
        }
    }
    @Test
    public void 책정보이름으로조회(){
        String name= "A10";
        List<BookInfo> bookInfos=bookInfoService.findBybookname(name);

        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookname());
        }
    }
    @Test
    public void 책정보비슷한이름으로조회(){
        String search= "A";
        List<BookInfo> bookInfos=bookInfoService.findBybooknameContaining(search);

        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookname());
        }
    }
}
