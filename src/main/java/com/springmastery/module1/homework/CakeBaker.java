package com.springmastery.module1.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    @Autowired
    public CakeBaker(@Qualifier("chocoFrosting") Frosting frosting,@Qualifier("strawberrySyrup") Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Frosting type: "+ this.frosting.getFrostingType());
        System.out.println("Syrup type: "+ this.syrup.getSyrupType());
    }
}
