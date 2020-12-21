package me.tairy.leetcode;

import me.tairy.leetcode.util.MatrixUtil;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-21 12:57
 * @link https://leetcode-cn.com/problems/transpose-matrix/
 */
public class TransposeMatrix {


    // memory: 39.3M time: 1ms
    // O(R * C)
    private static int[][] transpose(int[][] A) {

        if (null == A || A.length < 1) {
            return A;
        }

        int[][] result = new int[A[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] originMatrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixUtil.printMatrix(originMatrix);
        int[][] result = transpose(originMatrix);
        System.out.println("===========");
        MatrixUtil.printMatrix(result);
    }
}
