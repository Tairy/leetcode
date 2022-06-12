package me.tairy.leetcode2.array;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/19 下午4:03
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {-1};
        int[] res = sortedSquaresV3(nums);

        for (int num : res) {
            System.out.println(num);
        }
    }

    private static int[] sortedSquaresV2(int nums[]) {
        int divide = -1;
        for (int num : nums) {
            if (num < 0) {
                divide++;
            } else {
                break;
            }
        }

        int prev = divide;
        int next = divide + 1;
        int[] ret = new int[nums.length];
        int index = 0;
        while (prev >= 0 || next < nums.length) {

            if (next >= nums.length) {
                ret[index++] = squares(nums[prev--]);
            } else if (prev < 0) {
                ret[index++] = squares(nums[next++]);
            } else if (squares(nums[prev]) < squares(nums[next])) {
                ret[index++] = squares(nums[prev--]);
            } else {
                ret[index++] = squares(nums[next++]);
            }
        }

        return ret;
    }

    private static int[] sortedSquaresV3(int nums[]) {
        int divide = -1;
        for (int num : nums) {
            if (num < 0) {
                divide++;
            } else {
                break;
            }
        }

        int prev = divide;
        int next = divide + 1;
        int[] ret = new int[nums.length];
        int index = 0;
        while (prev >= 0 || next < nums.length) {
            int prevSquares = prev >= 0 ? squares(nums[prev]) : -1;
            int nextSquares = next < nums.length ? squares(nums[next]) : -1;

            if (prevSquares < 0 || (prevSquares >= nextSquares && nextSquares >= 0)) {
                ret[index++] = nextSquares;
                next++;
            } else {
                ret[index++] = prevSquares;
                prev--;
            }
        }

        return ret;
    }

    private static int[] sortedSquares(int nums[]) {
        int prev = -2;
        int next = nums.length;

        if (nums[0] >= 0) {
            prev = 0;
            next = 1;
        } else if (nums[nums.length - 1] < 0) {
            prev = nums.length - 2;
            next = nums.length - 1;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i < nums.length - 1 && nums[i] < 0 && nums[i + 1] >= 0) {
                    prev = i;
                    next = i + 1;
                }
            }
        }

        int[] res = new int[nums.length];

        for (int j = 0; j < nums.length; j++) {
            if (prev >= 0 && next < nums.length) {
                if (squares(nums[prev]) <= squares(nums[next])) {
                    res[j] = squares(nums[prev--]);
                } else {
                    res[j] = squares(nums[next++]);
                }
            } else if (next >= nums.length && prev >= 0) {
                res[j] = squares(nums[prev--]);
            } else if (next < nums.length) {
                res[j] = squares(nums[next++]);
            }
        }
        return res;
    }

    private static int squares(int num) {
        return num * num;
    }
}