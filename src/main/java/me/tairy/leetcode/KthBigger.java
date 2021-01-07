package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-07 15:09
 */
public class KthBigger {

    public static int hh(int[] nums, int k) {
        int[] ret = new int[k];
        int length = nums.length;

        for (int i = 0; i < k; i++) {
            ret[i] = nums[i];
        }

        for (int j = k; j < length; j++) {
            Arrays.sort(ret);

            if (ret[k - 1] > nums[j]) {
                ret[k - 1] = nums[j];
            }
        }

        return ret[k - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 2};
        System.out.println(hh(nums, 3));
    }
}
