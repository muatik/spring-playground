package com.muatik;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mustafaatik on 06/02/2017.
 */
public class ApplicationJavaUtilLogging {

    private static final Logger logger = Logger.getLogger(ApplicationJavaUtilLogging.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.INFO);
        logger.severe("severe...");
        logger.warning("warning...");
        logger.info("info...");
        // fine will not be logged
        logger.fine("fine...");

        logger.addHandler(new FileHandler("log.xml", true));
        logger.warning("warning 2");
        logger.severe("severe 2");
    }
}
