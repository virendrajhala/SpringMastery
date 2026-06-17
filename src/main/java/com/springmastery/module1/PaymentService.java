package com.springmastery.module1;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Service
//@Repository
//@RestController
//@Controller
public class PaymentService {

    public void pay(){
        System.out.println("Payment Made");
    }
}
