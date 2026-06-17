package com.springmastery.module1.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocoSyrup")
public class ChocolateSyrup implements Syrup{

    @Override
    public String getSyrupType() {
        return "Chocolate Syrup";
    }
}
