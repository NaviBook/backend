package KNU.Navibook.server.controller;

import KNU.Navibook.server.exceptions.BookNotFoundException;
import KNU.Navibook.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    @ResponseBody
    public Object returnUser(@RequestParam(value="id", required=false) String id){
        if(id==null)
            return userService.findAll();
        else {
            if (userService.findOne(id) == null) {
                throw new BookNotFoundException(String.format("bookInfoId %s not found", id));
            }
            return userService.findOne(id);
        }
    }

}
