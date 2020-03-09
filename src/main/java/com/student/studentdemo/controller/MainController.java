package com.student.studentdemo.controller;

import netscape.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/user")
    @ResponseBody
    public Principal user (Principal principal){
        return principal;
    }
}
