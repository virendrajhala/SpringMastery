package com.springmastery.module1;

import com.springmastery.module1.homework.Bakery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({EarlySelector.class, DeferredSelector.class})
public class Module1IntroductionApplication implements CommandLineRunner {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	Bakery bakery;


	public static void main(String[] args) {

		SpringApplication.run(Module1IntroductionApplication.class, args);
	}

	// this method is executed after all beans initialized and the app is ready to run
	// used here as main is static method and cant call an instance method without creating its object.
	@Override
	public void run(String... args) throws Exception {
		paymentService.pay();

		bakery.bake();
	}
}
