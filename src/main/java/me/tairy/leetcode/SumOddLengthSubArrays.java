package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 12:07
 * @link https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOddLengthSubArrays {

    // 4 ms
    // O(n^3)
    private int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        int length = arr.length;
        for (int i = 1; i <= length; i += 2) {
            for (int j = 0; j < length; j++) {
                for (int k = j; (j + i <= length) && (k < j + i); k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    private int sumOddLengthSubArraysOptVersion(int[] arr) {
        int length = arr.length;
        int sum = 0;
        int lEven, lOdd, rEven, rOdd;

        for (int i = 0; i < length; i++) {
            lEven = i / 2 + 1;
            lOdd = (i + 1) / 2;
            rEven = (length - i + 1) / 2;
            rOdd = (length - i) / 2;
            sum += arr[i] * (lEven * rEven + lOdd * rOdd);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        SumOddLengthSubArrays sumOddLengthSubArrays = new SumOddLengthSubArrays();
        System.out.printf("res: %d\n", sumOddLengthSubArrays.sumOddLengthSubArrays(arr));
        System.out.printf("res: %d\n", sumOddLengthSubArrays.sumOddLengthSubArraysOptVersion(arr));
    }
}
