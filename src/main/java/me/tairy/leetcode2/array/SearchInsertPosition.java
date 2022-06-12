package me.tairy.leetcode2.array;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/12 上午11:47
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.printf("result: %d", searchInsertPosition(nums, target));
    }

    private static int searchInsertPosition(int[] nums, int target) {

        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}