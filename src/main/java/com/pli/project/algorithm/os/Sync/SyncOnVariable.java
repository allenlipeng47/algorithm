package com.pli.project.algorithm.os.Sync;

/**
 * Created by lipeng on 2015/12/21.
 */

class PrintDemo3 {

    public void print() {
        for(int i=0; i<100; i++) {
            for(int j=0; j<5; j++)
                System.out.print(0);
            System.out.println();
        }
    }

}

public class SyncOnVariable implements Runnable{

    PrintDemo3 print = new PrintDemo3();

    public SyncOnVariable(PrintDemo3 print) {
        this.print = print;
    }

    public void run() {
        synchronized (print) {
            print.print();
        }
    }

    public static void main(String[] args) {
        PrintDemo3 printDemo3 = new PrintDemo3();
        Thread t0 = new Thread(new SyncOnVariable(printDemo3));
        Thread t1 = new Thread(new SyncOnVariable(printDemo3));
        t0.start();
        t1.start();
    }


}
