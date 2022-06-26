package me.tairy.leetcode2.array;

import java.util.ArrayList;
import java.util.List;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/7/2 上午11:40
 */
public class FindDisappearedNums {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = findDisappearedNumsV2(nums);
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    private static List<Integer> findDisappearedNums(int[] nums) {
        int diff = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int changeKey = nums[i] - 1;
            if (changeKey < 0) {
                changeKey = changeKey + diff;
            }
            if (nums[changeKey] > 0) {
                nums[changeKey] = nums[changeKey] - diff;
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                ret.add(j + 1);
            }
        }
        return ret;
    }

    private static List<Integer> findDisappearedNumsV2(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % len] += len;
        }

        List<Integer> ret = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= len) {
                ret.add(j + 1);
            }
        }
        return ret;
    }
}