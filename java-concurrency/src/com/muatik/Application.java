package com.muatik;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mustafaatik on 12/01/17.
 */
public class Application {

    public static void main(String[] args) {
        style3();
    }

    static void style1() {
        new Thread(new Service("s1", 3000)).start();
        new Thread(new Service("s2", 3000)).start();
        new Thread(new Service("s3", 3000)).start();
//        OUTPUT
//        start tag = s1, miliseconds = 3000
//        start tag = s2, miliseconds = 3000
//        start tag = s3, miliseconds = 3000
//        finish tag = s1, miliseconds = 3000
//        finish tag = s2, miliseconds = 3000
//        finish tag = s3, miliseconds = 3000
    }

    static void style2() {
        int NTHREDS = 2;
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        executor.execute(new Service("s3", 3000));
        executor.execute(new Service("s3", 3000));
        executor.execute(new Service("s3", 3000));
        executor.execute(new Service("s3", 3000));
        executor.execute(new Service("s3", 3000));
//        Output
//        Thu Jan 12 15:52:46 EET 2017 start tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:46 EET 2017 start tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:49 EET 2017 finish tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:49 EET 2017 finish tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:49 EET 2017 start tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:49 EET 2017 start tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:52 EET 2017 finish tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:52 EET 2017 finish tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:52 EET 2017 start tag = s3, miliseconds = 3000
//        Thu Jan 12 15:52:55 EET 2017 finish tag = s3, miliseconds = 3000
    }

    static void style3() {

        int nthreads = 3;
        int njobs = 5;

        List<Future<Long>> futures = new ArrayList<Future<Long>>();
        ExecutorService executors = Executors.newFixedThreadPool(nthreads);

        for (int i = 0; i < njobs; i++) {
            Callable<Long> callable = new CallableService("h" +i, 2000 + i * 200);
            Future<Long> future = executors.submit(callable);
            futures.add(future);
        }

        for (Future<Long> future : futures) {
            try {
                System.err.println(future.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

//        executors.shutdown();
//
//        Output
//        Thu Jan 12 16:39:29 EET 2017 start tag = h1, miliseconds = 2200
//        Thu Jan 12 16:39:29 EET 2017 start tag = h0, miliseconds = 2000
//        Thu Jan 12 16:39:29 EET 2017 start tag = h2, miliseconds = 2400
//        2000
//        Thu Jan 12 16:39:31 EET 2017 finish tag = h0, miliseconds = 2000
//        Thu Jan 12 16:39:31 EET 2017 start tag = h3, miliseconds = 2600
//        2200
//        Thu Jan 12 16:39:31 EET 2017 finish tag = h1, miliseconds = 2200
//        Thu Jan 12 16:39:31 EET 2017 start tag = h4, miliseconds = 2800
//        2400
//        Thu Jan 12 16:39:31 EET 2017 finish tag = h2, miliseconds = 2400
//        Thu Jan 12 16:39:34 EET 2017 finish tag = h3, miliseconds = 2600
//        2600
//        2800
//        Thu Jan 12 16:39:34 EET 2017 finish tag = h4, miliseconds = 2800
//
//        Process finished with exit code 0

    }

}
