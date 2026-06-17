package com.springmastery.module1.homework;

import org.springframework.stereotype.Component;

@Component
public class Bakery {

    private final CakeBaker baker;


    public Bakery(CakeBaker baker) {
        this.baker = baker;
    }

    public void bake(){
        baker.bakeCake();
    }
}
