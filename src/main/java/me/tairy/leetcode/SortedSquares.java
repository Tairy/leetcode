package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 11:11
 * @link https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {

    private int[] sortedSquares(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i] * nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }

    private int[] sortedSquaresWithDoublePoint1(int nums[]) {

        int divide = 0;
        int length = nums.length;

        for (int num : nums) {
            if (num <= 0) {
                divide++;
            } else {
                break;
            }
        }

        int[] ret = new int[length];
        int index = 0;
        int i = divide, j = divide - 1;

        while (i < length || j >= 0) {
            int iSquare = i < length ? nums[i] * nums[i] : -1;
            int jSquare = j >= 0 ? nums[j] * nums[j] : -2;

            if (iSquare != -1 && (iSquare <= jSquare || jSquare == -2)) {
                ret[index++] = iSquare;
                i++;
            } else {
                ret[index++] = jSquare;
                j--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
//        int[] nums = {-4, -1, 0, 3, 10};
//        int[] nums = {-7, -3, 2, 3, 11};
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {0};
        int[] nums = {-5, -3, -2, -1};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquaresWithDoublePoint1(nums)));
    }
}
