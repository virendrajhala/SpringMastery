package com.springmastery.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ExpensiveBean expensiveBean;

    @GetMapping("/test")
    public String test() {
        return "done";
    }
}