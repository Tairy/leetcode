package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-06 14:36
 */
public class BinarySearch {
    private static int search(int[] nums, int num) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > num) {
                right = mid - 1;
            } else if (nums[mid] < num) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 5};
        System.out.println(search(nums, 9));
    }
}
