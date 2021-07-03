/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mirekgab.singletonpattern;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mirek
 */
public class NaiveSingletonTest {

    public void test(int count) throws InterruptedException {
        Thread singletonThread1 = new Thread(new NaiveSingletonThread1(count));
        Thread singletonThread2 = new Thread(new NaiveSingletonThread2(count));
        singletonThread1.start();
        singletonThread2.start();
    }

    static class NaiveSingletonThread1 implements Runnable {
        private int count;

        private NaiveSingletonThread1(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            try {
                SingletonClassNaiveImplementation s = SingletonClassNaiveImplementation.getInstance("naive singleton thread 1");
                System.out.printf("test count: %2d\tthread number: 1\t value:%s\n",count, s.getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    static class NaiveSingletonThread2 implements Runnable {
        private int count;
        
        private NaiveSingletonThread2(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            try {
                SingletonClassNaiveImplementation s = SingletonClassNaiveImplementation.getInstance("naive singleton thread 2");
                System.out.printf("test count: %2d\tthread number: 2\t value:%s\n",count, s.getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
