package me.tairy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/20 下午6:30
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        byte[] strByteArr = s.getBytes();
        Map<Byte, Integer> strByteStat = new HashMap<>(16);
        for (byte b : strByteArr) {
            if (strByteStat.containsKey(b)) {
                strByteStat.put(b, strByteStat.get(b) + 1);
            } else {
                strByteStat.put(b, 1);
            }
        }

        int length = strByteArr.length;
        byte[] result = new byte[length];
        int index = 0;
        Map<Byte, Byte> strByteMap = new HashMap<Byte, Byte>(16);
        for (int i = 0; i < length; i++) {
            byte b = strByteArr[i];
            if (strByteStat.get(b) == 1) {
                result[index++] = b;
                continue;
            }

            if (!strByteMap.containsKey(b)) {

                if (i < length - 1) {
                    if (strByteArr[i] == strByteArr[i + 1]) {
                        continue;
                    }

                    if (strByteArr[i] < strByteArr[i + 1]) {
                        result[index++] = b;
                        strByteMap.put(b, b);
                        continue;
                    }

                    if (strByteArr[i] > strByteArr[i + 1]) {
                        boolean hasPeer = false;
                        for (int j = i + 1; j < length; j++) {
                            if (strByteArr[j] == strByteArr[i]) {
                                hasPeer = true;
                                break;
                            }
                        }

                        if (!hasPeer) {
                            result[index++] = b;
                            strByteMap.put(b, b);
                        }
                    }
                } else {
                    result[index++] = b;
                    strByteMap.put(b, b);
                }
            }
        }
        return new String(result, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("babc"));
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("ecbacba"));
        System.out.println(removeDuplicateLetters("leetcode"));
        System.out.println(removeDuplicateLetters("leetcodel"));
        System.out.println(removeDuplicateLetters("ccacbaba"));
        System.out.println(removeDuplicateLetters("cccccccccac"));
        System.out.println(removeDuplicateLetters("cccccccccc"));
    }
}