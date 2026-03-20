import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        // nextIndex[t] = closest index to the right having temperature t
        int[] nextIndex = new int[101];
        Arrays.fill(nextIndex, Integer.MAX_VALUE);

        for (int i = n - 1; i >= 0; i--) {
            int currTemp = temperatures[i];
            int nearestWarmerDay = Integer.MAX_VALUE;

            // check all warmer temperatures
            for (int t = currTemp + 1; t <= 100; t++) {
                nearestWarmerDay = Math.min(nearestWarmerDay, nextIndex[t]);
            }

            if (nearestWarmerDay != Integer.MAX_VALUE) {
                res[i] = nearestWarmerDay - i;
            }

            // update current temperature's nearest future occurrence
            nextIndex[currTemp] = i;
        }

        return res;
    }
}