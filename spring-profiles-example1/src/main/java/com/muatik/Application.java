package com.muatik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

/**
 * Created by mustafaatik on 18/01/17.
 */
@SpringBootApplication
@EnableConfigurationProperties(ConfigBinder.class)
public class Application {

    @Value("${my.name}")
    private String name;

    @Value("${spring.jpa.show-sql}")
    private boolean showSql;

    public static void main(String[] args) {
        final ApplicationContext ctx = SpringApplication.run(Application.class, args);
        final ConfigBinder confs = ctx.getBean(ConfigBinder.class);
        System.out.println(confs.getUrl());
        System.out.println(confs.getName());
    }

}
