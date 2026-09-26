import java.util.*;

class Solution {

    private static final int OFFSET = 100_000;
    private static final int SIZE = 200_001;

    public List<List<Integer>> threeSum(int[] nums) {

        int[] freq = new int[SIZE];

        int min = 100_000;
        int max = -100_000;

        // O(n)
        for (int x : nums) {
            freq[x + OFFSET]++;

            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // a must be <= 0
        for (int a = min; a <= Math.min(0, max); a++) {

            int fa = freq[a + OFFSET];

            if (fa == 0)
                continue;

            /*
             * We enforce:
             *
             * a <= b <= c
             *
             * c = -a-b
             */

            int startB = a;

            // b <= c
            // b <= -a-b
            // 2b <= -a
            int endB = Math.min(max, (-a) / 2);

            for (int b = startB; b <= endB; b++) {

                int fb = freq[b + OFFSET];

                if (fb == 0)
                    continue;

                int c = -a - b;

                // enforce b <= c
                if (c < b)
                    continue;

                if (c < -100_000 || c > 100_000)
                    continue;

                int fc = freq[c + OFFSET];

                if (fc == 0)
                    continue;

                // -----------------------
                // Multiplicity checking
                // -----------------------

                if (a == b && b == c) {

                    if (fa < 3)
                        continue;

                } else if (a == b) {

                    if (fa < 2)
                        continue;

                } else if (b == c) {

                    if (fb < 2)
                        continue;
                }

                ans.add(Arrays.asList(a, b, c));
            }
        }

        return ans;
    }
}