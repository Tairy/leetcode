package me.tairy.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-30 15:25
 */
public class CountDownLatchDemo {

    private static class RunnerThread extends Thread {

        private CountDownLatch runnerCountDownLatch;

        private CountDownLatch refereeCountDownLatch;

        private int id;

        RunnerThread(CountDownLatch runnerCountDownLatch, CountDownLatch refereeCountDownLatch, int id) {
            this.runnerCountDownLatch = runnerCountDownLatch;
            this.refereeCountDownLatch = refereeCountDownLatch;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                refereeCountDownLatch.await();
                System.out.printf("start to run at %d\n", System.currentTimeMillis());
                Thread.sleep(id * 1000);
                System.out.printf("runner_%d stopped, time: %d.\n", this.id, System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                runnerCountDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatchReferee = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner = new CountDownLatch(4);

        Thread threadReferee = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.printf("command to start at: %d\n", System.currentTimeMillis());
                countDownLatchReferee.countDown();

                countDownLatchRunner.await();
                System.out.printf("all runner stopped, %d.\n", System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadReferee.start();

        for (int i = 0; i < 4; i++) {
            RunnerThread thread = new RunnerThread(countDownLatchRunner, countDownLatchReferee, i + 1);
            thread.start();
        }
    }
}
