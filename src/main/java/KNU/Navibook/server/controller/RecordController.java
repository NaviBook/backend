package KNU.Navibook.server.controller;

import KNU.Navibook.server.domain.Record;
import KNU.Navibook.server.domain.User;
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

    @GetMapping("/api/record/user/{userId}")
    @ResponseBody
    public List<Record> userRecord(@PathVariable("userId") String userId,
                                   @RequestParam("page") Integer page, @RequestParam("orderBy") String orderBy)
    {
        User user = userService.findOne(userId);
        List<Record> records = recordService.findRecordByUser(user);
        List<Record> pageRecords = new ArrayList<>();

        if (orderBy.equals("book")){ // bookName 오름차순 정렬
            Comparator<Record> bs = Comparator.comparing(a -> a.getBook().getBookInfo().getBookName());
            Collections.sort(records, bs);
        }
        else if (orderBy.equals("takeDate")){ // TakeDate 오름차순 정렬
            Comparator<Record> ts = Comparator.comparing(Record::getTakeDate);
            Collections.sort(records, ts);
        }
        else if (orderBy.equals("giveDate")){ // GiveDate 오름차순 정렬
            Comparator<Record> gs = Comparator.comparing(Record::getGiveDate);
            Collections.sort(records, gs);
        }

        for(int i = (page*10)-10; (records != null) && (records.size() > i) && (i < page*10); i++){
            pageRecords.add(records.get(i));
        }

        return pageRecords;
    }

}

