package me.tairy.leetcode2.array;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/27 下午11:11
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "aab";
        System.out.printf("result: %d", lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            Character rightC = s.charAt(right);
            while (map.containsKey(rightC)) {
//                System.out.printf("left: %d, right: %d\n", left, right);
                map.remove(s.charAt(left++));
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            map.put(rightC, right);
        }

        return maxLen;
    }
}