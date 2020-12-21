package me.tairy.leetcode;

import me.tairy.leetcode.util.MatrixUtil;

/**
 * package: me.tairy.leetcode
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-21 13:15
 * @link https://leetcode-cn.com/problems/subrectangle-queries/
 * <p>
 * 暴力解法
 */
public class SubRectangleQueries {

    public int[][] rectangle = null;

    public SubRectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    // time 32 ms, memory: 42.2 MB
    public void updateSubRectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {

        if (null == this.rectangle || row > this.rectangle.length || col > this.rectangle[0].length) {
            return 0;
        }

        return this.rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] originMatrix = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};
//        MatrixUtil.printMatrix(originMatrix);
        SubRectangleQueries subRectangleQueries = new SubRectangleQueries(originMatrix);
        System.out.println(subRectangleQueries.getValue(0, 2));
        subRectangleQueries.updateSubRectangle(0, 0, 3, 2, 5);
//        MatrixUtil.printMatrix(subRectangleQueries.rectangle);
        System.out.println(subRectangleQueries.getValue(0, 2));
        System.out.println(subRectangleQueries.getValue(3, 1));
        subRectangleQueries.updateSubRectangle(3, 0, 3, 2, 10);
//        MatrixUtil.printMatrix(subRectangleQueries.rectangle);
    }
}
