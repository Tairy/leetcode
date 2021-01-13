package me.tairy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-11 13:46
 */
public class SmallestStringWithSwaps {

    private static void swap(char[] charList, int i, int j) {
        if (charList[i] > charList[j]) {
            char temp = charList[i];
            charList[i] = charList[j];
            charList[j] = temp;
        }
    }

    private static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] charList = s.toCharArray();
        for (List<Integer> pair : pairs) {
            swap(charList, pair.get(0), pair.get(1));
        }

//        InheritableThreadLocal

        return new String(charList);
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs =
                new LinkedList<List<Integer>>() {{
                    add(new LinkedList<Integer>() {{
                        add(0);
                        add(3);
                    }});
                    add(new LinkedList<Integer>() {{
                        add(1);
                        add(2);
                    }});
                    add(new LinkedList<Integer>() {{
                        add(0);
                        add(2);
                    }});
                }};

        System.out.println(smallestStringWithSwaps("dcab", pairs));
    }
}
