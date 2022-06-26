package me.tairy.leetcode2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/7/2 下午3:00
 */
public class ClimbStairs {

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.printf("result: %d", climbStairsV2(45));
    }

    /**
     * f(1) = 1
     * f(2) = 2
     * f(3) = f(1) + f(2)
     */
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int ret = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, ret);
        return ret;
    }

    private static int climbStairsV2(int n) {
        int p = 0, q = 0, r = 1;

        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}