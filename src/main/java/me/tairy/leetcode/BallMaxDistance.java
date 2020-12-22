package me.tairy.leetcode;

import java.util.Arrays;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.comc
 * @date 2020-12-22 09:39
 * @link https://leetcode-cn.com/problems/magnetic-force-between-two-balls/
 */
public class BallMaxDistance {

    private boolean check(int mid, int[] position, int m) {
        int base = position[0];
        int cnt = 1;

        for (int value : position) {
            if (value - base >= mid) {
                base = value;
                cnt++;
            }
        }

        return cnt >= m;
    }

    private int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = -1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] position = {1, 2, 3, 4, 7};
//        int m = 3;
        int[] position = {5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        BallMaxDistance ballMaxDistance = new BallMaxDistance();
        int result = ballMaxDistance.maxDistance(position, m);
        System.out.printf("result: %d", result);
    }
}
