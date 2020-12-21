package me.tairy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-21 09:29
 * @link https://leetcode-cn.com/problems/two-sum/
 */
public class TowSum {

    /**
     * 0 ms
     *
     * @param nums   数组
     * @param target 检索和
     * @return 结果
     */
    private static int[] toSumWithHash(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(16);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsKey(diff) && i != hashMap.get(diff)) {
                result[0] = hashMap.get(diff);
                result[1] = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        return result;
    }

    /**
     * 10 ms
     *
     * @param nums   数组
     * @param target 检索和
     * @return 结果
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;

        int[] result = toSumWithHash(nums, target);

        for (int i = 0; i < 2; i++) {
            System.out.println(result[i]);
        }
    }
}
