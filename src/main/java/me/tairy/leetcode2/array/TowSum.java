package me.tairy.leetcode2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/27 下午10:50
 */
public class TowSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;

        int[] result = twoSum(nums, target);
        System.out.printf("[%d, %d]\n", result[0], result[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.containsKey(diff)) {
                result[0] = numToIndex.get(diff);
                result[1] = i;
                return result;
            }
            numToIndex.put(nums[i], i);
        }
        return result;
    }
}