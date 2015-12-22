package com.pli.project.algorithm.thread;

import sun.awt.Mutex;

import java.util.concurrent.Semaphore;

/**
 * Created by pli on 12/22/2015.
 */
public class ProducerConsumer {

    public static final int MAX_AVAILABLE = 5;

    Semaphore empty = new Semaphore(MAX_AVAILABLE);

    Semaphore full = new Semaphore(MAX_AVAILABLE);

    Semaphore mutex = new Semaphore(1);

    public void run() {
        for(int i=0; i<2; i++) {
            new Thread(new Consumer()).start();
        }
        new Thread(new Producer()).start();
    }

    class Producer implements Runnable {
        public void run() {
            while (true) {
                try {
                    empty.acquire();
                    mutex.acquire();    // each time, only one thread can modify full or empty semaphore
                    if (full.availablePermits() < 5)
                        full.release();
                    System.out.println("producer" + Thread.currentThread().getId() + ", full " + full.availablePermits() + ", empty " + empty.availablePermits());
                    mutex.release();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("producer is interrupted");
                }

            }

        }
    }

    class Consumer implements Runnable {
        public void run() {
            while (true) {
                try {
                    full.acquire();
                    mutex.acquire();    // each time, only one thread can modify full or empty semaphore
                    if (empty.availablePermits() < 5)
                        empty.release();
                    System.out.println("consumer" + Thread.currentThread().getId() + ", full " + full.availablePermits() + ", empty " + empty.availablePermits());
                    mutex.release();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("producer is interrupted");
                }
            }

        }
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumer pc = new ProducerConsumer();
        pc.empty.acquire(MAX_AVAILABLE);
        pc.run();
    }

}
