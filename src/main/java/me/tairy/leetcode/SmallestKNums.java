package me.tairy.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 下午12:07
 */
public class SmallestKNums {

    private int[] smallestK(int[] arr, int k) {
        int length = arr.length;
        int[] ret = new int[k];

        System.arraycopy(arr, 0, ret, 0, k);

        for (int i = k; i < length; i++) {
            Arrays.sort(ret);
            if (ret[k - 1] > arr[i]) {
                ret[k - 1] = arr[i];
            }
        }
        return ret;
    }

    private int quickSelect(int[] arr, int k, int start, int end) {
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        int pivot = arr[index];
        swap(arr, index, end);

        int left = start, right = end;

        while (left < right) {
            if (arr[left++] >= arr[right]) {
                swap(arr, --left, --right);
            }
        }

        swap(arr, left, end);

        int m = left - start;

        if (m == k - 1) {
            return pivot;
        } else if (k <= m) {
            return quickSelect(arr, k, start, left - 1);
        } else {
            return quickSelect(arr, k - m, left, end);
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        SmallestKNums smallestKNums = new SmallestKNums();
        int[] nums = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] r = smallestKNums.smallestK(nums, 4);
        System.out.println(Arrays.toString(r));
        int ret = smallestKNums.quickSelect(nums, 4, 0, nums.length - 1);
        System.out.println(ret);
    }
}