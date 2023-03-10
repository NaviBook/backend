package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.Book;
import KNU.Navibook.server.domain.Record;
import KNU.Navibook.server.domain.User;
import KNU.Navibook.server.dto.RecordDTO;
import KNU.Navibook.server.exceptions.BookNotFoundException;
import KNU.Navibook.server.exceptions.RecordNotFoundException;
import KNU.Navibook.server.exceptions.UserNotFoundException;
import KNU.Navibook.server.service.BookService;
import KNU.Navibook.server.service.RecordService;
import KNU.Navibook.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
    public RecordDTO allRecord(@RequestParam("orderBy") String orderBy) {
        List<Record> records = recordService.findRecords();

        if (orderBy.equals("book")){ // bookName 오름차순 정렬
            Comparator<Record> bs = Comparator.comparing(a -> a.getBook().getBookInfo().getBookName());
            Collections.sort(records, bs);
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
        else if (orderBy.equals("user")){ // userId 오름차순 정렬
            Comparator<Record> us = Comparator.comparing(a -> a.getUser().getId());
            Collections.sort(records, us);
        }
        else{
            throw new RecordNotFoundException(String.format("orderBy %s not found", orderBy));
        }

        RecordDTO recordDTO = new RecordDTO(records, records.size());

        return recordDTO;
    }
    @GetMapping("/api/record/user/{userId}") // userId로 userRecord 검색
    @ResponseBody
    public RecordDTO userRecord(@PathVariable("userId") String userId,
                                @RequestParam("orderBy") String orderBy)
    {
        User user = userService.findOne(userId);
        List<Record> records = recordService.findRecordByUser(user);

        if (user==null){
            throw new UserNotFoundException(String.format("userId %s not found",userId));
        }

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
        else{
            throw new RecordNotFoundException(String.format("orderBy %s not found", orderBy));
        }

        RecordDTO recordDTO = new RecordDTO(records, records.size());

        return recordDTO;
    }
    @GetMapping("/api/record/book/{bookId}") //bookId로 bookRecord 검색
    @ResponseBody
    public RecordDTO bookRecord(@PathVariable("bookId") Long bookId)
    {
        Book book = bookService.findOne(bookId);
        List<Record> records = recordService.findRecordByBook(book);

        Comparator<Record> ts = Comparator.comparing(Record::getTakeDate);
        Collections.sort(records, ts);
        Collections.reverse(records);

        if (book==null){
            throw new BookNotFoundException(String.format("bookId %s not found",bookId));
        }

        RecordDTO recordDTO = new RecordDTO(records, records.size());

        return recordDTO;
    }
}

