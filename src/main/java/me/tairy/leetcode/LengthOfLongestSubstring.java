package me.tairy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020-12-22 15:02
 */
public class LengthOfLongestSubstring {

    // 9 ms
    private int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>(16);
        int maxLength = 0;
        byte[] bytes = s.getBytes();
        int front = -1;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (window.contains(c)) {
                while (s.charAt(++front) != c) {
                    window.remove(s.charAt(front));
                }
                window.remove(s.charAt(front));
            }

            window.add(c);

            if (maxLength < window.size()) {
                maxLength = window.size();
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String[] strList = {"dvdf", "pwwkew", "ckilbkd", "aab"};
        for (String str : strList) {
            System.out.printf("%s => length: %d\n", str, lengthOfLongestSubstring.lengthOfLongestSubstring(str));
        }
    }

}
