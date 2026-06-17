package com.springmastery.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class MyConfig {
//    @Bean
//    public DataSource dataSource() {
//        System.out.println("MY custom DataSource created!");
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2).build();
//    }
//}

// below config bean created to make the @ConditionalOnMissingBean
// for GreetingAutoConfiguration as not matched because we as a user have provided the bean
// so that auto config will not create the bean, boot will step aside

@Configuration
public class MyConfig {
    @Bean
    public GreetingService greetingService() {
        System.out.println("MY custom GreetingService created!");
        return new GreetingService("Namaste");
    }
}
