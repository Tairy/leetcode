package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-07 18:41
 */
public class QuickSort {

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        while (left < right) {
            while (left < right && nums[low] <= nums[right]) {
                right--;
            }

            while (left < right && nums[low] >= nums[left]) {
                left++;
            }
            swap(nums, left, right);
        }

        swap(nums, left, low);
        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 6, 8, 3, 2, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
