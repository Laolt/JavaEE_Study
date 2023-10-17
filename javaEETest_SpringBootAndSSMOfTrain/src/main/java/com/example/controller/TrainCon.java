package com.example.controller;


import com.example.service.trainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/trains")
public class TrainCon {
    @Autowired
    trainService t;
    @GetMapping("/{page}")
    public Result selectAll(@PathVariable int page){
        System.out.println("666");
        return new Result(20041,t.selectAll(page));
    }
    @GetMapping
    public Result selectAll(){
        System.out.println("666");
        return new Result(20041,t.selectAll(0));
    }
}
