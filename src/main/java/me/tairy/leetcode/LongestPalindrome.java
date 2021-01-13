package me.tairy.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-10 22:15
 * @link https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 栈只能解决找到回文串，无法解决找到最长的问题
     *
     * @param s 字符串
     * @return 结果
     */
    private static String longestPalindromeWithStack(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        Deque<Character> ret = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            Character prevChar = stack.pop();

            if (c.equals(prevChar)) {
                while (c.equals(prevChar)) {
                    ret.offerFirst(prevChar);
                    ret.offerLast(c);
                    if (i >= length - 1) {
                        break;
                    }
                    c = s.charAt(++i);
                    prevChar = stack.pop();
                }
            } else {
                if (stack.size() > 0) {
                    Character topChar = stack.pop();
                    if (c.equals(topChar)) {
                        ret.offerFirst(prevChar);
                        ret.offerFirst(topChar);
                        ret.offerLast(c);
                        if (i < length - 1 && stack.size() > 0) {
                            c = s.charAt(++i);
                            prevChar = stack.pop();
                        }
                    } else {
                        stack.push(topChar);
                        stack.push(prevChar);
                        stack.push(c);
                    }
                } else {
                    stack.push(prevChar);
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = ret.size();
        for (int j = 0; j < size; j++) {
            sb.append(ret.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeWithStack("babad"));
        System.out.println(longestPalindromeWithStack("babadab"));
        System.out.println(longestPalindromeWithStack("bcaac"));
    }
}
