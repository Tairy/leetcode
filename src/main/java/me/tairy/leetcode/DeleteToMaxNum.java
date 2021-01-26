package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-26 09:34
 */
public class DeleteToMaxNum {

    private static int[] deleteToMaxNum(int[] nums, int k) {
        int length = nums.length;
        int[] ret = new int[length - k + 1];
        int i = 0;
        int t = k;
        int newIndex = 0;
        while (t-- > 0) {
            for (i = 0; i < length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }

            while (i + 1 < length) {
                nums[i] = nums[i + 1];
                i++;
            }

            nums[i] = 0;

            length--;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(deleteToMaxNum(nums, 5)));
    }
}
