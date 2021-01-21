package me.tairy.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-13 21:08
 */
public class ProductConsumerWithSync {

    private final static Object lock = new Object();

    private static Deque<Integer> queue = new LinkedList<>();

    private static final Integer MAX_QUEUE_SIZE = 10;

    private static Random random = new Random();

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Product()).start();
        new Thread(new Product()).start();
        new Thread(new Product()).start();
        new Thread(new Product()).start();

        new Thread(new Consumer()).start();
    }

    private static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (queue.size() >= MAX_QUEUE_SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.push(random.nextInt());
                    lock.notifyAll();
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (queue.size() <= 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(queue.pop());
                    lock.notifyAll();
                }
            }
        }
    }
}
