package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-10 10:29
 * @link https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
public class FindMissingNumber {

    private static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid < nums[mid]) {
                right = mid - 1;
            } else if (mid == nums[mid]) {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(nums));
    }
}
