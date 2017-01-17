package com.muatik;

import java.util.Date;

/**
 * Created by mustafaatik on 12/01/17.
 */
public class Service implements Runnable {

    protected String tag;
    protected int miliseconds;

    Service(String tag, int miliseconds) {
        this.tag = tag;
        this.miliseconds = miliseconds;
    }

    public void process(String tag, int miliseconds) {

        System.out.println(new Date().toString() + " start tag = " + tag + ", miliseconds = " + miliseconds);
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date().toString() + " finish tag = " + tag + ", miliseconds = " + miliseconds);
    }

    @Override
    public void run() {
        process(tag, miliseconds);
    }
}
