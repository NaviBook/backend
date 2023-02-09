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
                                   @RequestParam("page") Integer page)//, @RequestParam("orederBy") String orderBy)
    {
        User user = userService.findOne(userId);
        List<Record> records = recordService.findRecordByUser(user);
        List<Record> pageRecords = new ArrayList<>();

//        Comparator<Record> cp = Comparator.comparing(Record::getGiveDate);
//        Collections.sort(records, cp);

        for(int i = (page*10)-10; records != null && records.size() >= i && i <= page*10; i++){
            pageRecords.add(records.get(i));
        }

        return pageRecords;
    }

}

