package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-14 10:32
 */
public class Weibo {

    private static int binarySearch(int[] nums, int left, int right, int num) {

        int length = nums.length;

        int i = left;
        int j = right;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] > num) {
                j = mid - 1;
            } else if (nums[mid] < num) {
                i = mid + 1;
            } else {
                return i;
            }
        }

        return -1;
    }

    private static int f(int a, int b, int n) {
        if (n == 0) {
            return a;
        }

        return f(b, a + b, n - 1);
    }

    // 二分查找
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(nums, 0, nums.length - 1, 2));
        System.out.println(f(0, 1, 10));
    }
}
