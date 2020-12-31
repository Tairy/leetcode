package me.tairy.leetcode;

import java.util.concurrent.CyclicBarrier;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-31 09:43
 * public CyclicBarrier(int parties, Runnable barrierAction)
 * 第一个参数，表示一起执行的线程个数。
 * 第二个参数，表示线程都处于barrier时，一起执行之前，先执行的一个线程。
 */
public class CyclicBarrierDemo {

    private static class RunnerThread extends Thread {

        int id;

        CyclicBarrier cyclicBarrier;

        RunnerThread(CyclicBarrier cyclicBarrier, int id) {
            this.cyclicBarrier = cyclicBarrier;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(id * 1000);
                System.out.printf("runner_%d is ready, time: %d\n", id, System.currentTimeMillis());
                cyclicBarrier.await();
                System.out.printf("runner_%d is starting to run, time: %d\n", id, System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.printf("main_thread run at: %d\n", System.currentTimeMillis());
        });

        for (int i = 0; i < 4; i++) {
            RunnerThread runnerThread = new RunnerThread(cyclicBarrier, i);
            runnerThread.start();
        }
    }
}
