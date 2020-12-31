package me.tairy.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

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

//        ArrayBlockingQueue
//        LinkedBlockingQueue
//        PriorityBlockingQueue
//        DelayQueue
//        SynchronousQueue
//        LinkedTransferQueue
//        LinkedBlockingQueue
//        ThreadPoolExecutor
//        ReentrantLock
//        NoRe
//        Thread
//        AtomicReference
//        ConcurrentHashMap
//        Deque
//        Properties
//        Hashtable
//        HashMap
        ThreadLocal<String> local = new ThreadLocal<String>();
        local.set("sss");

//        Thread

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

    private int firstUniqCharOptVersion(String s) {
        return -1;
    }


    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
//        int n = cap;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.printf("result: %d\n", firstUniqChar.firstUniqChar("loveleetcode"));
        System.out.printf("result: %d\n", firstUniqChar.firstUniqChar("cc"));
        System.out.printf("result: %d\n", firstUniqChar.firstUniqCharOptVersion("cc"));
//        CountDownLatch

//        int i = 32;
//        System.out.println(i >>> 16);
//        Collection
//        HashMap
//        ConcurrentHashMap
        System.out.println(tableSizeFor(16));
//        Deque s = new ArrayDeque();
//        s.peek()
    }
}