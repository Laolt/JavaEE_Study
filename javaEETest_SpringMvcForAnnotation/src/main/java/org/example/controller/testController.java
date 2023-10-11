package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//使用@Controller定义bean来定义controller
@Controller
public class testController {
    //    通过@RequestMapping设置访问路径
//    通过@ResponseBody设置操作的返回值类型
    @ResponseBody
    @GetMapping("/save")
    public String save() {
        System.out.println("666");
        return "<html><h1>sad</h1></html>";
    }
}