package me.tairy.leetcode2.array;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/7/2 下午4:04
 */
public class MergeSortedArray_88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        mergeV2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length - 1;
        for (int j = len; j >= 0; j--) {
            if (m <= 0) {
                nums1[j] = nums2[n - 1];
                n--;
            } else if (n <= 0) {
                nums1[j] = nums1[m - 1];
                m--;
            } else {
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[j] = nums1[m - 1];
                    m--;
                } else {
                    nums1[j] = nums2[n - 1];
                    n--;
                }
            }
        }
    }

    private static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int j = nums1.length - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[j--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[j--] = nums1[p1--];
            } else {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[j--] = nums1[p1--];
                } else {
                    nums1[j--] = nums2[p2--];
                }
            }
        }
    }
}