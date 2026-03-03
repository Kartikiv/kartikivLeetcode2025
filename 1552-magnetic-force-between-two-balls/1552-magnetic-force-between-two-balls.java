import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;

        int right = Arrays.stream(position).max().getAsInt() - Arrays.stream(position).min().getAsInt();
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left ) / 2;
            if (canPack(position, mid, m)) {
                ans = mid;
               left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return right;
    }

    private boolean canPack(int[] pos, int dist, int m) {
        int balls = 1;          // place first ball at pos[0]
        int prev = pos[0];

        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - prev >= dist) {
                balls++;
                prev = pos[i];
                if (balls >= m) return true;
            }
        }
        return false;
    }


}