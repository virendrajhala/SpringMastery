package com.springmastery.module1;

public class GreetingService {

    private String prefix;

    public GreetingService(String prefix){
        this.prefix = prefix;
    }

    public String greet(String name){
        return this.prefix + ", " + name + "!";
    }
}
