package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/24 下午6:41
 */
public class IntDivide {

    private int divide(int dividend, int divisor) {
        if (0 == dividend) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }

    private int divideWithSub(int dividend, int divisor) {
        if (0 == dividend) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long m = Math.abs((long) divisor);

        int result = 0;
        while (t - m >= 0) {
            result++;
            t -= m;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        IntDivide intDivide = new IntDivide();
        System.out.println(intDivide.divide(-2147483648, 2));
        System.out.println(intDivide.divideWithSub(-2147483648, 2));
        System.out.println(intDivide.divide(-2147483648, 1));
        System.out.println(intDivide.divideWithSub(-2147483648, 1));
    }
}