package me.tairy.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-12 18:06
 */
public class ProductConsumer {

    private static Deque<Integer> queue = new LinkedList<>();

    private static Integer MAX_QUEUE_SIZE = 10;

    public static void main(String[] args) {

        Random random = new Random();

        Thread productThread = new Thread(() -> {
            while (true) {
                if (queue.size() <= 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(queue.pop());
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                if (queue.size() >= MAX_QUEUE_SIZE) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    queue.push(random.nextInt());
                }
            }
        });

        productThread.start();
        consumerThread.start();
    }
}
