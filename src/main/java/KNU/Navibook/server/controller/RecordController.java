package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.Record;
import KNU.Navibook.server.domain.User;
import KNU.Navibook.server.service.BookService;
import KNU.Navibook.server.service.RecordService;
import KNU.Navibook.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@Controller
public class RecordController {
    @Autowired
    RecordService recordService;
    @Autowired
    UserService userService;
    @Autowired
    BookService bookService;


    @GetMapping("/api/record") // record 전체 검색
    @ResponseBody
    public List<Record> allRecord(@RequestParam("page") Integer page, @RequestParam("orderBy") String orderBy) {
        List<Record> records = recordService.findRecords();
        List<Record> pageRecords = new ArrayList<>();

        if (orderBy.equals("book")){ // bookName 오름차순 정렬
            Comparator<Record> bs = Comparator.comparing(a -> a.getBook().getBookInfo().getBookName());
            Collections.sort(records, bs);
        }
        else if (orderBy.equals("takeDate")){ // TakeDate 내림차순 정렬
            Comparator<Record> ts = Comparator.comparing(Record::getTakeDate);
            Collections.sort(records, ts);
            Collections.reverse(records);
        }
        else if (orderBy.equals("giveDate")){ // GiveDate 내림차순 정렬
            Comparator<Record> gs = Comparator.comparing(Record::getGiveDate);
            Collections.sort(records, gs);
            Collections.reverse(records);
        }
        else if (orderBy.equals("user")){ // userId 오름차순 정렬
            Comparator<Record> us = Comparator.comparing(a -> a.getUser().getId());
            Collections.sort(records, us);
        }else{ // 예외처리 해줘야 함.

        }

        for(int i = (page*10)-10; (records != null) && (records.size() > i) && (i < page*10); i++){
            pageRecords.add(records.get(i));
        }

        return pageRecords;
    }
    @GetMapping("/api/record/user/{userId}") // userId로 userRecord 검색
    @ResponseBody
    public List<Record> userRecord(@PathVariable("userId") String userId,
                                   @RequestParam("page") Integer page, @RequestParam("orderBy") String orderBy)
    {
        User user = userService.findOne(userId);
        List<Record> records = recordService.findRecordByUser(user);
        List<Record> pageRecords = new ArrayList<>();

        if (orderBy.equals("book")){ // bookName 내림차순 정렬
            Comparator<Record> bs = Comparator.comparing(a -> a.getBook().getBookInfo().getBookName());
            Collections.sort(records, bs);
            Collections.reverse(records);
        }
        else if (orderBy.equals("takeDate")){ // TakeDate 내림차순 정렬
            Comparator<Record> ts = Comparator.comparing(Record::getTakeDate);
            Collections.sort(records, ts);
            Collections.reverse(records);
        }
        else if (orderBy.equals("giveDate")){ // GiveDate 내림차순 정렬, 반납 안했으면 제일 앞으로 옴.
            Comparator<Record> gs = Comparator.comparing(Record::getGiveDate, Comparator.nullsLast(Comparator.naturalOrder()));
            Collections.sort(records, gs);
            Collections.reverse(records);
        }
        else{// 예외처리 해줘야 함.

        }

        for(int i = (page*10)-10; (records != null) && (records.size() > i) && (i < page*10); i++){
            pageRecords.add(records.get(i));
        }

        return pageRecords;
    }
    @GetMapping("/api/record/book/{bookId}") //bookId로 bookRecord 검색
    @ResponseBody
    public List<Record> bookRecord(@PathVariable("bookId") Long bookId,
                                   @RequestParam("page") Integer page)
    {
        Book book = bookService.findOne(bookId);
        List<Record> records = recordService.findRecordByBook(book);
        List<Record> pageRecords = new ArrayList<>();

        Comparator<Record> ts = Comparator.comparing(Record::getTakeDate);
        Collections.sort(records, ts);
        Collections.reverse(records);

        for(int i = (page*10)-10; (records != null) && (records.size() > i) && (i < page*10); i++){
            pageRecords.add(records.get(i));
        }

        return pageRecords;
    }
}

