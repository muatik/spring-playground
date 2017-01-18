package com.muatik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * Created by mustafaatik on 18/01/17.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final ApplicationContext ctx = SpringApplication.run(Application.class, args);
        final ConfigBinder confs = ctx.getBean(ConfigBinder.class);
        final ConfigValueBinder confs2 = ctx.getBean(ConfigValueBinder.class);

        System.out.println(confs.getUrl());
        System.out.println(confs.getName());

        System.out.println(confs2.getUrl());
        System.out.println(confs2.getName());
    }

}
