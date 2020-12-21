package me.tairy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode
 *
 * @author <fangzhang> fangzhang@ibantang.com
 * @date 2020-12-21 14:43
 * @link https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class FindMajorityElement {

    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];

        while (left < right) {
            while (temp <= nums[right] && left < right) {
                --right;
            }

            if (left < right) {
                nums[left] = nums[right];
                ++left;
            }

            while (temp >= nums[left] && left < right) {
                ++left;
            }

            if (left < right) {
                nums[right] = nums[left];
                --right;
            }
        }

        nums[left] = temp;
        return left;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (nums.length <= 1 || left >= right) {
            return;
        }

        int mid = partition(nums, left, right);
        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, right);
    }

    // time: O(nlogn), space: O(1)
    private int majorityElementWithSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i + nums.length / 2 < nums.length; i++) {
            if (nums[i] == nums[i + nums.length / 2]) {
                return nums[i];
            }
        }

        return -1;
    }

    // time: O(n), space: O(n)
    private int majorityElementWithHashMap(final int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
        for (int num : nums) {

            Integer total = map.get(num);

            if (null == total) {
                map.put(num, 1);
                total = 0;
            } else {
                map.put(num, total + 1);
            }

            if ((total + 1) * 2 > nums.length) {
                return num;
            }
        }
        return -1;
    }

    // time: O(n), space: O(1)
    private int majorityElementWithMooreVote(int[] nums) {
        int major = 0, cnt = 0;

        for (int num : nums) {
            if (0 == cnt) {
                major = num;
                cnt++;
            } else {
                if (major == num) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        System.out.printf("cnt: %d\n", cnt);
        if (cnt > 0) {
            int t = 0;
            for (int num : nums) {
                if (num == major) {
                    t++;
                }
            }
            if (t > nums.length / 2) {
                return major;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 5, 5, 3, 3, 5, 6};
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {4, 3, 2, 1};
        FindMajorityElement findMajorityElement = new FindMajorityElement();
        System.out.printf("sort: %d\n", findMajorityElement.majorityElementWithSort(nums));
        System.out.printf("hash_map: %d\n", findMajorityElement.majorityElementWithHashMap(nums));
        System.out.printf("moore_vote: %d\n", findMajorityElement.majorityElementWithMooreVote(nums));
    }
}
