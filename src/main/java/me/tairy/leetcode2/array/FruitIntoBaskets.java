package me.tairy.leetcode2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/26 下午9:44
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.printf("result: %d", totalFruit(nums));
    }

    private static int totalFruit(int[] fruits) {

        Map<Integer, Integer> counter = new HashMap<>();

        int i = 0;
        int total = 0;
        for (int j = 0; j < fruits.length; j++) {
            if (counter.containsKey(fruits[j])) {
                counter.put(fruits[j], counter.get(fruits[j]) + 1);
            } else {
                counter.put(fruits[j], 1);
            }

            while (counter.size() >= 3) {
                counter.put(fruits[i], counter.get(fruits[i]) - 1);
                if (counter.get(fruits[i]) == 0) {
                    counter.remove(fruits[i]);
                }
                i++;
            }

            total = Math.max(total, j - i + 1);
        }

        return total;
    }
}