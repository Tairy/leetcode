package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-21 16:28
 * @link https://leetcode-cn.com/problems/find-the-winner-of-an-array-game/
 * <p>
 * 打擂台逻辑
 * <p>
 * 有两种打法：
 * <p>
 * 1. 低下排队的人一次上擂台和擂主打，赢了的替换一直打，时间复杂度高。
 * 2. 队首的人直接去跟每一个打，输了的话用赢他的那个继续打，直到打到队尾或者超过对战轮数。
 */
public class GetWinner {

    private void printQueue(int[] arr, int front, int end, int length) {

        if (end < front) {
            end = length + end;
        }

        System.out.printf("front: %d, end: %d\n", front, end);

        for (int i = front; i <= end; i++) {
            System.out.printf("%d\t", arr[i % length]);
        }
        System.out.print("\n");
    }

    // 1 ms
    private int getWinnerSimple(int[] arr, int k) {
        int i = 0, t = 0;
        while (t < k && i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                arr[i + 1] = arr[i];
                ++t;
            } else {
                t = 1;
            }

            ++i;
        }

        return arr[i];
    }

    // 4 ms, 49.9 MB 第一版本
    private int getWinner(int[] arr, int k) {
        int length = arr.length;
        int front = 0;
        int end = length - 1;

        int prevWinner = 0;
        int currentWinner = 0;
        int currentLoser = 0;
        int winCount = 0;

        while (true) {
            int first = arr[front++ % length]; // lpop
            int second = arr[front++ % length]; // lpop
            prevWinner = currentWinner;

            if (first < second) {
                currentWinner = second;
                currentLoser = first;
            } else {
                currentWinner = first;
                currentLoser = second;
            }

            arr[(length + ++end) % length] = currentLoser;
            arr[(length + --front) % length] = currentWinner;

            this.printQueue(arr, front, end, length);

            if (currentWinner == prevWinner) {
                winCount++;
            } else {
                winCount = 1;
            }

            if (winCount >= k || front == length - 1) {
                break;
            }
        }

        return arr[(length + front) % length];
    }

    private int getWinnerOpt(int[] arr, int k) {
        int length = arr.length;
        int front = 0;
        int end = length - 1;

        int prevWinner = 0;
        int currentWinner = 0;
        int winCount = 0;

        while (winCount < k && front < length - 1) {
            if (arr[front] > arr[front + 1]) {
                arr[front + 1] = arr[front];
                winCount++;
            } else {
                winCount = 1;
            }

            front++;
        }

        return arr[front];
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 5, 4, 6, 7};
//        int k = 2;

//        int[] arr = {3, 2, 1};
//        int k = 10;

//        int[] arr = {1, 9, 8, 2, 3, 7, 6, 4, 5};
//        int k = 7;

        //[2,1,3,5,4,6,7]
        //2

        int[] arr = {1, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        int k = 1000000000;

//        int[] arr = {2, 1, 3, 5, 4, 6, 7};
//        int k = 2;

        GetWinner getWinner = new GetWinner();
        int winner = getWinner.getWinnerOpt(arr, k);
        System.out.printf("winner is: %d", winner);
    }
}
