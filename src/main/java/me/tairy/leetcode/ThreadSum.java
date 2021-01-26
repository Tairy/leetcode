package me.tairy.leetcode;

import java.util.concurrent.*;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-25 11:58
 */
public class ThreadSum {

    private static int total = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static Object object = new Object();

    private static void sum(int[] nums) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS
                , new LinkedBlockingDeque<>(10));

        for (int num : nums) {
            SumThread thread = new SumThread();
            thread.setNum(num);
            executorService.submit(thread);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sum(nums);

        try {
            countDownLatch.await();
            System.out.println(total);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class SumThread implements Runnable {

        int num;

        @Override
        public void run() {
            synchronized (object) {
                total += num;
                countDownLatch.countDown();
            }
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
