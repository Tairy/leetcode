package me.tairy.leetcode2.array;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/12 下午1:14
 * <p>
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * @link <a href="https://programmercarl.com/0034.%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E6%9F%A5%E6%89%BE%E5%85%83%E7%B4%A0%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%92%8C%E6%9C%80%E5%90%8E%E4%B8%80%E4%B8%AA%E4%BD%8D%E7%BD%AE.html#%E6%80%9D%E8%B7%AF">...</a>
 */
public class FindFirstAndEndPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7};
        int target = 6;
        int[] result = findFirstAndEndPosition(nums, target);
        System.out.printf("result: [%d, %d]\n", result[0], result[1]);
    }

    private static int[] findFirstAndEndPosition(int[] nums, int target) {

        int leftBorder = findLeftBorder(nums, target);
        int rightBorder = findRightBorder(nums, target);

        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }

        if (rightBorder >= leftBorder) {
            return new int[]{leftBorder, rightBorder};
        }

        return new int[]{-1, -1};
    }

    private static int findRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = mid;
            }
        }

        return rightBorder;
    }

    private static int findLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
                leftBorder = mid;
            } else {
                left = mid + 1;
            }
        }

        return leftBorder;
    }
}