package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-10 10:50
 * @link https://leetcode-cn.com/problems/sparse-array-search-lcci/
 */
public class FindString {

    private static int findString(String[] words, String s) {
        int length = words.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int mid_temp = mid;

            while (mid <= right && words[mid].equals("")) {
                mid++;
            }

            if (mid > right) {
                right = mid_temp - 1;
                continue;
            }

            if (s.compareTo(words[mid]) < 0) {
                right = mid - 1;
            } else if (s.compareTo(words[mid]) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(findString(words, "ta"));
    }
}
