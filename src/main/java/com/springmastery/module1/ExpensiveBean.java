package com.springmastery.module1;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ExpensiveBean {

    public ExpensiveBean() {
        System.out.println(">>> ExpensiveBean CONSTRUCTED");
    }

    @PostConstruct
    public void init() {
        System.out.println(">>> ExpensiveBean @PostConstruct");
    }
}
