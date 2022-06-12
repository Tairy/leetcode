package me.tairy.leetcode2.array;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/19 下午2:31
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int target = 2;
        int len = removeElementV2(nums, target);
        System.out.printf("new_length: %d\n", len);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int removeElement(int[] nums, int target) {
        int slow = 0;
        int findNums = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == target) {
                findNums++;
            } else {
                if (nums[slow] == target) {
                    nums[slow] = nums[fast];
                    nums[fast] = target;
                    for (int j = slow; j < fast && nums[slow] != target; j++) {
                        slow++;
                    }
                } else {
                    slow++;
                }
            }
        }

        return nums.length - findNums;
    }

    private static int removeElementV2(int[] nums, int target) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != target) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}