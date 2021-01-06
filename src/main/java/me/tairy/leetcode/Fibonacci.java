package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/24 下午5:39
 */
public class Fibonacci {

    private int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    private int tailRecursionFib(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        return tailRecursionFib(n - 1, b, (a + b) % 1000000007);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(100));
        int sum = 0;
        System.out.println(fibonacci.tailRecursionFib(100, 0, 1));
        System.out.println(sum);
    }
}