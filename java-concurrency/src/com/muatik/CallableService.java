package com.muatik;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by mustafaatik on 12/01/17.
 */
public class CallableService implements Callable<Long> {
    private String tag;
    private int miliseconds;

    CallableService(String tag, int miliseconds) {
        this.tag = tag;
        this.miliseconds = miliseconds;
    }

    @Override
    public Long call() throws Exception {
        System.out.println(new Date().toString() + " start tag = " + tag + ", miliseconds = " + miliseconds);
        Thread.sleep(miliseconds);
        System.out.println(new Date().toString() + " finish tag = " + tag + ", miliseconds = " + miliseconds);
        return Long.valueOf(miliseconds);
    }
}
