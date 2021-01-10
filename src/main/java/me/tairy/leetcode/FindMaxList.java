package me.tairy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-08 16:19
 */
public class FindMaxList {

    private static int[] findMaxUpList(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        int first = 0, second = -1;
        int maxLength = 0;
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {

            if (nums[first + 1] > nums[first]) {
                ret.add(nums[first]);
                first++;
            } else {
                int listLength = first - second;
                if (listLength > maxLength) {
                    maxLength = listLength;
                    ret.clear();
                }
            }
        }

        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {9, 8, 2, 4, 5, 6};

        int[] ret = findMaxUpList(nums);

        System.out.println(Arrays.toString(ret));
    }
}
