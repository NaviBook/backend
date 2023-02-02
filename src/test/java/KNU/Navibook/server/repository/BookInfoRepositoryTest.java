package KNU.Navibook.server.repository;
import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.BookInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import java.util.List;

@SpringBootTest
class BookInfoRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookInfoRepository bookInfoRepository;

    @Test
    public List<BookInfo> 책정보전체조회(){
        List<BookInfo> bookInfos=bookInfoRepository.findAll();
        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
        return bookInfos;
    }
    @Test
    public List<BookInfo> 책정보이름으로조회(String name){
        List<BookInfo> bookInfos=bookInfoRepository.findBybookName(name);
        for(BookInfo bookInfo:bookInfos){
            System.out.println(bookInfo.getBookName());
        }
        return bookInfos;
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
    @Test
    @Transactional
    public BookInfo 책정보등록(){
        String bookname="test";
        String writer="ajin";
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookName(bookname);
        bookInfo.setWriter(writer);

        BookInfo saveBookInfo;

        saveBookInfo=bookInfoRepository.save(bookInfo);

        System.out.println(saveBookInfo.getId());
        return saveBookInfo;
    }
//    @Test
//    @Transactional
//    public void 책정보삭제(){
//        BookInfo newbookinfo=책정보등록();
//        String name=newbookinfo.getBookName();
//        List<BookInfo>bookInfos = 책정보이름으로조회(name);
//        for (BookInfo bookInfo : bookInfos){
//            System.out.println(bookInfo);
//        }
//        bookInfoRepository.deleteByid(newbookinfo.getId());
//        List<BookInfo>bookInfos2 = 책정보이름으로조회(name);
//        for (BookInfo bookInfo : bookInfos2){
//            System.out.println(bookInfo);
//        }
//    }
//    @Test
//    @Transactional
//    public void 책정보수정(){
//        BookInfo bookInfo=new BookInfo();
//        bookInfo.setWriter("Park");
//        bookInfo.setBookName("Jiwon");
//        bookInfo.setId(999L);
//        bookInfoRepository.save(bookInfo);
//
//
//        String newName="Kwon";
//        String newWriter=("Dawoon");
//        int newbookinfo= bookInfoRepository.updateByid(newName,newWriter, 9994L);
//
//        BookInfo newbook = bookInfoRepository.findByid(bookInfo.getId());
//
//        System.out.println(newbookinfo);
//        System.out.println(newbook.getBookName());
//
//    }
}