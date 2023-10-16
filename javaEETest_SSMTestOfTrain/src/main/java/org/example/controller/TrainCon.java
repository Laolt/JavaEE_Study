package org.example.controller;

import org.example.service.trainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/trains")
public class TrainCon {
    @Autowired
    trainService t;
    @GetMapping("/{page}")
    public Result selectAll(@PathVariable int page){
        return new Result(20041,t.selectAll(page));
    }
}
