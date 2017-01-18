package com.muatik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mustafaatik on 17/01/17.
 */
@Service
public class MyEntity {
    private static final Logger logger = LoggerFactory.getLogger(MyEntity.class);

    @Async(value = "somethingExecutor")
    public void doSomethingSlow(String id, long sleep) {
        logger.info(String.format("%s starting doing something very slow. %d", id, sleep));
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(String.format("%s something very slow finished.", id));
    }

    @Async(value = "emailSender")
    public void sendEmail(String id, long sleep) {
        logger.info(String.format("%s sending email. %d\n", id, sleep));
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(String.format("%s email sent .\n", id));
    }

}
