package me.tairy.leetcode2.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * package: me.tairy.leetcode2.array
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2022/6/28 下午11:02
 */
public class MinWindow_76 {
    public static void main(String[] args) {
        String s = "bbaa";
        String t = "aba";

//        System.out.println("aaa".indexOf("a"));

        System.out.printf("result: %s", minWindow(s, t));
    }

    private static String minWindow(String s, String t) {

        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int retLeft = -1;
        int retRight = -1;

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> subMap = new HashMap<>();

        for (int j = 0; j < t.length(); j++) {
            Character c = t.charAt(j);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            Character ss = s.charAt(right);
            subMap.put(ss, subMap.getOrDefault(ss, 0) + 1);
            while (left <= right && check(subMap, tMap)) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    retLeft = left;
                    retRight = right;
                }

                Character leftC = s.charAt(left);
                Integer v = subMap.get(leftC);
                if (v <= 1) {
                    subMap.remove(leftC);
                } else {
                    subMap.put(leftC, v - 1);
                }
                left++;
            }
        }

        if (retLeft < 0 || retRight < 0) {
            return "";
        }

        return s.substring(retLeft, retRight + 1);
    }

    private static boolean check(Map<Character, Integer> subMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character k = entry.getKey();
            if (!subMap.containsKey(k) || subMap.get(k) < tMap.get(k)) {
                return false;
            }
        }
        return true;
    }
}