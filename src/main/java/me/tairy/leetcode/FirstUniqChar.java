package me.tairy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 下午12:34
 */
public class FirstUniqChar {

    // 53 ms -> 10ms
    // time: O(n), memory: O(Σ)
    public int firstUniqChar(String s) {
        int length = s.length();
        Set<Character> remember = new HashSet<>(8);

        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            boolean hasRepeat = remember.contains(c);
            if (hasRepeat) {
                continue;
            }
            remember.add(c);
            for (int j = i + 1; j < length; ++j) {
                if (c == s.charAt(j)) {
                    hasRepeat = true;
                    break;
                }
            }

            if (!hasRepeat) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharOptVersion(String s) {
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.printf("result: %d\n", firstUniqChar.firstUniqChar("loveleetcode"));
        System.out.printf("result: %d\n", firstUniqChar.firstUniqChar("cc"));
        System.out.printf("result: %d\n", firstUniqChar.firstUniqCharOptVersion("cc"));
    }
}