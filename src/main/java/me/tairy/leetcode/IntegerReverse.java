package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-21 11:02
 * @link https://leetcode-cn.com/problems/reverse-integer/
 */
public class IntegerReverse {

    // memory: 35.4, time: 1ms
    private static int lowMemoryReverse(int num) {
        int result = 0;
        while (0 != num) {
            int pop = num % 10;
            num /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop == 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop == -8)) {
                return 0;
            }

            result = result * 10 + pop;
        }

        return result;
    }

    // memory 35.5M, time 1ms
    private static int integerReverse(int num) {
        long result = 0;
        int length = 0;
        int tmp = num;

        while (tmp != 0) {
            length++;
            tmp = tmp / 10;
        }

        tmp = num;
        long[] intArr = new long[length];
        int index = 0;

        while (tmp != 0) {
            intArr[index++] = tmp % 10;
            tmp = tmp / 10;
        }

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length - i - 1; j++) {
                intArr[i] *= 10;
            }
            result += intArr[i];
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(lowMemoryReverse(Integer.MAX_VALUE));
        System.out.println(lowMemoryReverse(1234));
        System.out.println(lowMemoryReverse(-1234));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
