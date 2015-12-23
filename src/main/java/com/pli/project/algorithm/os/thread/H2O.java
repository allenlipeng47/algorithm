package com.pli.project.algorithm.os.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by pli on 12/22/2015.
 * H2O problem. There are several H factories producing H, several O factories producing O. Once there are 2 Hs and 1 Os, it
 * can generate a drop of water H2O. Make a multi-thread for this problem
 */
public class H2O {

    private int h;

    private int o;

    Semaphore mutex = new Semaphore(1);

    private void produceH2O() {
        System.out.println(Thread.currentThread().getId() + " enter h:" + h + ", o:" + o);
        if(h>=2 && o>=1) {
            h = h-2;
            o = o-1;
            System.out.println("H2O");
        }
        System.out.println(Thread.currentThread().getId() + " leave status h:" + h + ", o:" + o);
    }

    class WaterFactoryH implements Runnable {
        public void run() {
            while (true) {
                try {
                    mutex.acquire();
                    h++;
                    produceH2O();
                    mutex.release();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("thread is interrupted");
                }
            }
        }
    }

    class WaterFactoryO implements Runnable {
        public void run() {
            while (true) {
                try {
                    mutex.acquire();
                    o++;
                    produceH2O();
                    mutex.release();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("thread is interrupted");
                }
            }
        }
    }

    public void run() {
        for(int i=0; i<2; i++)
            new Thread(new WaterFactoryH()).start();
        for(int i=0; i<2; i++)
            new Thread(new WaterFactoryO()).start();
    }


    public static void main(String[] args) {
        H2O h2o = new H2O();
        h2o.run();
    }

}
