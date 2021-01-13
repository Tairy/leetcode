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

    private static int i = 0;

    private final static Object lockObject = new Object();

    private static void printNumWithSemaphore(int[] nums) {
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

    private static void printNumWithLock(int[] nums) {
        Thread threadEven = new Thread(() -> {
            while (i < nums.length) {
                synchronized (lockObject) {
                    System.out.println(nums[i++]);
                    lockObject.notify();

                    if (i >= nums.length) {
                        break;
                    }

                    try {
                        lockObject.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadOdd = new Thread(() -> {
            while (i < nums.length) {
                synchronized (lockObject) {
                    System.out.println(nums[i++]);
                    lockObject.notify();

                    if (i >= nums.length) {
                        break;
                    }

                    try {
                        lockObject.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadEven.start();
        threadOdd.start();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        printNumWithSemaphore(nums);
        printNumWithLock(nums);
    }
}
