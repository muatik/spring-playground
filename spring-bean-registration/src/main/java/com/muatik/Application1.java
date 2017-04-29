package com.muatik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class Application1 {
    
    @Bean
    FooService getfoodService() {
        return new FooService();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                Application1.class);
    }

}


class FooService {

}

@Component
class BarService {

    private FooService fooService;

    public BarService(FooService fooService) {
        this.fooService = fooService;
    }

}
