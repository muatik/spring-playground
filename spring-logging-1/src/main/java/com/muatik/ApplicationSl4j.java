package com.muatik;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mustafaatik on 06/02/2017.
 */
public class ApplicationSl4j {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ApplicationSl4j.class.getName());
        logger.debug("debug");
        logger.info("info title: {} ", "title 1");
        logger.warn("warning");
        logger.error("error");
    }
}
