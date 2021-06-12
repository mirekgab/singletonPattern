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
public class SingletonTest {

    public void test(int count) throws InterruptedException {
        Thread singletonThread1 = new Thread(new SingletonThread1(count));
        Thread singletonThread2 = new Thread(new SingletonThread2(count));
        singletonThread1.start();
        singletonThread2.start();
    }

    static class SingletonThread1 implements Runnable {
        private int count;

        private SingletonThread1(int count) {
            this.count = count;
        }
        
        @Override
        public void run() {
            try {
                SingletonClass s = SingletonClass.getInstance("singleton thread 1");
                System.out.printf("count %2d\tthread 1\t%s\n",count, s.getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    static class SingletonThread2 implements Runnable {
        private int count;

        private SingletonThread2(int count) {
            this.count = count;
        }
        
        @Override
        public void run() {
            try {
                SingletonClass s = SingletonClass.getInstance("singleton thread 2");
                System.out.printf("count %2d\tthread 2\t%s\n",count, s.getName());
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
