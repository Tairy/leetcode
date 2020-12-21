package me.tairy.leetcode.util;

/**
 * package: me.tairy.leetcode.util
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-21 13:26
 */
public class MatrixUtil {

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }

            System.out.print("\n");
        }
    }
}
