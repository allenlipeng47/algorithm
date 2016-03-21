package com.pli.project.algorithm.ms;

import java.util.concurrent.Semaphore;

/**
 * Created by lipeng on 2016/3/20.
 */
public class H2O {

    private Semaphore mutexH;
    private Semaphore mutexO;
    private int h;
    private int o;

    class ProducerH implements Runnable {
        public void run() {
            while (true) {
                try {
                    mutexH.acquire();
                    h++;
                    mutexH.release();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Exception:" + e);
                }
            }
        }
    }

    class ProducerO implements Runnable {
        public void run() {
            while (true) {
                try {
                    mutexO.acquire();
                    o++;
                    mutexO.release();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Exception:" + e);
                }
            }
        }
    }

    class ProducerH2O implements Runnable {
        public void run() {
            while (true) {
                try {
                    mutexH.acquire();
                    mutexO.acquire();
                    if (o >= 1 && h >= 2) {
                        System.out.println("o: " + o + ", h: " + h + "\tH2O");
                        o--;
                        h -= 2;
                    }
                    mutexO.release();
                    mutexH.release();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
        }
    }

    public H2O() {
        mutexH = new Semaphore(1);
        mutexO = new Semaphore(2);
        new Thread(new ProducerH()).start();
        new Thread(new ProducerO()).start();
        new Thread(new ProducerH2O()).start();
    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
    }

}
