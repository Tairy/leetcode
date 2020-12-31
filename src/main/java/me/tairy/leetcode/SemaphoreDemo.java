package me.tairy.leetcode;

import java.util.concurrent.Semaphore;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-28 11:48
 */
public class SemaphoreDemo {

    private static int i = 0;

    public static void main(String[] args) {

        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0);

        // C -> B -> A
        Thread A = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("a run over.");
                i = 10;
                semaphoreA.release(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread B = new Thread(() -> {
            try {
                semaphoreA.acquire();
                System.out.println("b run over. num is " + i);
                Thread.sleep(1000);
                i = 20;
                semaphoreB.release(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread C = new Thread(() -> {
            try {
                semaphoreB.acquire();
                System.out.println("c run over. num is " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A.start();
        B.start();
        C.start();
    }
}
