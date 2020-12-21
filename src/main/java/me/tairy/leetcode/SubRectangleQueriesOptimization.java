package me.tairy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * package: me.tairy.leetcode
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-21 13:58
 * @link https://leetcode-cn.com/problems/subrectangle-queries/
 * <p>
 * 非暴力解法
 * <p>
 * update O(1)
 */
public class SubRectangleQueriesOptimization {

    public int[][] rectangle = null;

    public List<Integer> history = new ArrayList<Integer>();

    public SubRectangleQueriesOptimization(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    // time 34 ms, memory: 42.2 MB
    public void updateSubRectangleQueriesOptimization(int row1, int col1, int row2, int col2, int newValue) {
        history.add(row1);
        history.add(row2);
        history.add(col1);
        history.add(col2);
        history.add(newValue);
    }

    public int getValue(int row, int col) {

        if (null == this.rectangle || row > this.rectangle.length || col > this.rectangle[0].length) {
            return 0;
        }

        for (int i = history.size() - 1; i >= 4; i -= 5) {
            if (history.get(i - 1) >= col
                    && history.get(i - 2) <= col
                    && history.get(i - 3) >= row
                    && history.get(i - 4) <= row) {
                return history.get(i);
            }
        }

        return this.rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] originMatrix = {{3, 9, 4}, {5, 6, 10}};
        SubRectangleQueriesOptimization subRectangleQueriesOptimization = new SubRectangleQueriesOptimization(originMatrix);
        subRectangleQueriesOptimization.updateSubRectangleQueriesOptimization(1, 1, 1, 1, 5);
        System.out.println(subRectangleQueriesOptimization.getValue(1, 0));
        System.out.println(subRectangleQueriesOptimization.getValue(1, 0));
        subRectangleQueriesOptimization.updateSubRectangleQueriesOptimization(0, 0, 1, 0, 6);
        System.out.println(subRectangleQueriesOptimization.getValue(1, 0));
        System.out.println(subRectangleQueriesOptimization.getValue(0, 1));
    }
}
