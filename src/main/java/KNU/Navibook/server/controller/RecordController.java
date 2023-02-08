package KNU.Navibook.server.controller;

import KNU.Navibook.server.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecordController {
    @Autowired
    RecordService recordService;


}

