package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 下午12:07
 */
public class SmallestKNums {

    public int[] smallestK(int[] arr, int k) {
        
        return new int[]{1, 2, 3, 4};
    }

    public static void main(String[] args) {
        SmallestKNums smallestKNums = new SmallestKNums();
        int[] nums = {1, 3, 4, 5, 6, 2};
        int[] ret = smallestKNums.smallestK(nums, 2);
        for (int j : ret) {
            System.out.printf("%d\t", j);
        }
        System.out.print("\n");
    }
}