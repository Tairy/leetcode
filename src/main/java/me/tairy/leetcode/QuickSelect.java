package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-07 19:24
 */
public class QuickSelect {

    private static int quickSelect(int[] nums, int k, int start, int end) {
        int index = partition(nums, start, end);

        if (index - start == k) {
            return index;
        } else if (index - start > k) {
            return quickSelect(nums, k, start, index - 1);
        } else {
            return quickSelect(nums, k - (index - start + 1), index + 1, end);
        }
    }

    private static int partition(int[] num, int low, int high) {
        int left = low;
        int right = high;

        while (left < right) {

            while (left < right && num[right] >= num[low]) {
                right--;
            }

            while (left < right && num[left] <= num[low]) {
                left++;
            }

            swap(num, left, right);
        }

        swap(num, low, left);
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6, 8};
        int index = quickSelect(nums, 4, 0, nums.length - 1);
        int[] ret = new int[index];
        System.arraycopy(nums, 0, ret, 0, index);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(nums));
    }
}
