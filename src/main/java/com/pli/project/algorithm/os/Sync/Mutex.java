package com.pli.project.algorithm.os.Sync;

/**
 * Created by lipeng on 2015/12/21.
 */

class PrintDemo {

    public synchronized void print() {
        for(int i=0; i<100; i++) {
            for(int j=0; j<5; j++)
                System.out.print(0);
            System.out.println();
        }
    }

}

public class Mutex implements Runnable{

    PrintDemo print = new PrintDemo();

    public Mutex(PrintDemo print) {
        this.print = print;
    }

    public void run() {
        print.print();
    }

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
        Thread t0 = new Thread(new Mutex(printDemo));
        Thread t1 = new Thread(new Mutex(printDemo));
        t0.start();
        t1.start();
    }


}
