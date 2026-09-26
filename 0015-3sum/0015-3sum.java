import java.util.*;

class Solution {

    private static final int OFFSET = 100_000;
    private static final int SIZE = 200_001;

    public List<List<Integer>> threeSum(int[] nums) {

        int[] freq = new int[SIZE];

        int min = 100_000;
        int max = -100_000;

        // 1. Frequency table: O(n)
        for (int x : nums) {
            freq[x + OFFSET]++;

            if (x < min) min = x;
            if (x > max) max = x;
        }

        // 2. Build sorted distinct values
        int distinctCount = 0;

        for (int x = min; x <= max; x++) {
            if (freq[x + OFFSET] != 0)
                distinctCount++;
        }

        int[] values = new int[distinctCount];

        int k = 0;

        for (int x = min; x <= max; x++) {
            if (freq[x + OFFSET] != 0)
                values[k++] = x;
        }

        List<List<Integer>> ans = new ArrayList<>();

        // 3. Iterate only existing values
        for (int i = 0; i < distinctCount; i++) {

            int a = values[i];

            // a <= b <= c and sum = 0
            // therefore a cannot be positive.
            if (a > 0)
                break;

            // Even using the two largest values can't reach zero
            if ((long) a +
                values[distinctCount - 1] +
                values[distinctCount - 1] < 0) {
                continue;
            }

            for (int j = i; j < distinctCount; j++) {

                int b = values[j];

                // c = -a-b
                int c = -a - b;

                // enforce b <= c
                if (c < b)
                    break;

                // c can't exist outside our actual input range
                if (c > max)
                    continue;

                int fc = freq[c + OFFSET];

                if (fc == 0)
                    continue;

                // Multiplicity
                if (a == b) {

                    if (b == c) {
                        if (freq[a + OFFSET] < 3)
                            continue;
                    } else {
                        if (freq[a + OFFSET] < 2)
                            continue;
                    }

                } else if (b == c) {

                    if (freq[b + OFFSET] < 2)
                        continue;
                }

                ans.add(Arrays.asList(a, b, c));
            }
        }

        return ans;
    }
}