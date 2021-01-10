package me.tairy.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-10 15:39
 */
public class AlterPrintNum {


    private static void printNum(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int length = nums.length;
        AtomicInteger index = new AtomicInteger(0);
        Semaphore semaphoreOdd = new Semaphore(1);
        Semaphore semaphoreEven = new Semaphore(0);

        Thread threadOdd = new Thread(() -> {
            try {
                while (index.get() < length) {
                    semaphoreEven.acquire(1);
                    System.out.println(nums[index.get()]);
                    if (index.incrementAndGet() >= length) {
                        break;
                    }
                    semaphoreOdd.release(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadEven = new Thread(() -> {
            try {
                while (index.get() < length) {
                    semaphoreOdd.acquire(1);
                    System.out.println(nums[index.get()]);
                    if (index.incrementAndGet() >= length) {
                        break;
                    }
                    semaphoreEven.release(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadOdd.start();
        threadEven.start();
    }
}
