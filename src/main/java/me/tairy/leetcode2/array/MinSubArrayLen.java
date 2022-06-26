package me.tairy.leetcode2.array;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/26 下午6:41
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8};
        int target = 80;

        System.out.printf("result: %d", minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int windowSum = 0;
        int minWindowLen = Integer.MAX_VALUE;

        for (int fast = 0; fast < nums.length; fast++) {
            windowSum += nums[fast];
            while (windowSum >= target) {
                int len = fast - slow + 1;
                minWindowLen = Math.min(minWindowLen, len);
                windowSum -= nums[slow++];
//                System.out.printf("slow: %d, fast: %d, len: %d, min_len: %d, sum: %d\n", slow, fast, len, minWindowLen, windowSum);
            }
        }

        return minWindowLen == Integer.MAX_VALUE ? 0 : minWindowLen;
    }
}