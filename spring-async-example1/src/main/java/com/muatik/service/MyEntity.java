package com.muatik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mustafaatik on 17/01/17.
 */
@Service
public class MyEntity {
    private static final Logger logger = LoggerFactory.getLogger(MyEntity.class);

    @Async
    public void doSomethingSlow(long sleep) {
        System.err.println("starting doing something very slow.");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("finished something very slow.");
    }

}
