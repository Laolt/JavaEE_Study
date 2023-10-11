package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("666");
        return "<html><h1>666</h1></html>";
    }

}
