package me.tairy.leetcode;

/**
 * package: PACKAGE_NAME
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 上午10:03
 */
public class FindMedianSortedArrays {

    // O(m + n)
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int totalLength = nums1Length + nums2Length;
        int num1Index = 0;
        int num2Index = 0;
        int mod = totalLength % 2;
        int[] result = new int[totalLength / 2 + 1];

        for (int i = 0; i <= totalLength / 2; i++) {

            if (num1Index >= nums1Length && num2Index >= nums2Length) {
                break;
            }

            if (num1Index >= nums1Length) {
                result[i] = nums2[num2Index++];
                continue;
            }

            if (num2Index >= nums2Length) {
                result[i] = nums1[num1Index++];
                continue;
            }

            if (nums1[num1Index] < nums2[num2Index]) {
                result[i] = nums1[num1Index];
                num1Index++;
            } else if (nums1[num1Index] >= nums2[num2Index]) {
                result[i] = nums2[num2Index];
                num2Index++;
            }
        }

        return mod == 0 ? (result[result.length - 1] + result[result.length - 2]) / 2.0 : result[result.length - 1];
    }

    // O(log(m + n))
    private double findMedianSortedArraysOptVersion(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        int leftK = (nums1Length + nums2Length + 1) / 2;
        int rightK = (nums1Length + nums2Length + 2) / 2;

        return (getKth(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, leftK) + getKth(nums1, 0, nums1Length - 1, nums2, 0, nums2Length - 1, rightK)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {

        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 始终保持 len1 比 len2 小
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] num1 = {2};
        int[] num2 = {};
        System.out.printf("result: %.2f\n", findMedianSortedArrays.findMedianSortedArrays(num1, num2));
        System.out.printf("result: %.2f\n", findMedianSortedArrays.findMedianSortedArraysOptVersion(num1, num2));
    }
}