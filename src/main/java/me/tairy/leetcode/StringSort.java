package me.tairy.leetcode;

import java.util.*;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2021-01-08 11:15
 */
public class StringSort {

    private List<String> sort(List<String> givenOrder, List<String> list) {
        Map<String, Integer> givenStrMap = new HashMap<>();
        Map<Integer, String> indexToStr = new HashMap<>();
        List<Integer> indexList = new LinkedList<>();
        List<String> retList = new LinkedList<>();

        for (int i = 0; i < givenOrder.size(); i++) {
            givenStrMap.put(givenOrder.get(i), i);
            indexToStr.put(i, givenOrder.get(i));
        }

        for (String listItem : list) {
            Integer index = givenStrMap.get(listItem);

            if (null == index) {
                continue;
            }

            indexList.add(index);
        }

        indexList.sort((a, b) -> {
            if (a > b) {
                return 1;
            } else if (a.equals(b)) {
                return 0;
            } else {
                return -1;
            }
        });

        for (Integer item : indexList) {
            retList.add(indexToStr.get(item));
        }

        return retList;
    }

    public static void main(String[] args) {
        StringSort stringSort = new StringSort();
        String[] originList = {"2#", "E2#", "5#", "E5#", "8#", "E8#", "0#", "-1#", "-2#"};
        String[] list = {"-2#", "E2#", "-2#", "8#", "2#"};
        System.out.println(stringSort.sort(Arrays.asList(originList), Arrays.asList(list)).toString());
    }
}
