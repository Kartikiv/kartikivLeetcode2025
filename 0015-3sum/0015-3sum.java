import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        final int MIN = -100000;
        final int MAX = 100000;
        final int OFFSET = 100000;

        int[] freq = new int[200001];

        // O(n)
        for (int x : nums) {
            freq[x + OFFSET]++;
        }

        List<List<Integer>> result = new ArrayList<>();

        // IMPORTANT:
        // Don't iterate from -100000 to 100000 twice.
        // Extract only values that actually exist.
        List<Integer> values = new ArrayList<>();

        for (int x = MIN; x <= MAX; x++) {
            if (freq[x + OFFSET] > 0) {
                values.add(x);
            }
        }

        for (int i = 0; i < values.size(); i++) {

            int a = values.get(i);

            for (int j = i; j < values.size(); j++) {

                int b = values.get(j);

                // a <= b <= c
                int c = -(a + b);

                if (c < b)
                    continue;

                if (c < MIN || c > MAX)
                    continue;

                if (freq[c + OFFSET] == 0)
                    continue;

                // a == b == c
                if (a == b && b == c) {

                    if (freq[a + OFFSET] >= 3) {
                        result.add(Arrays.asList(a, b, c));
                    }

                // a == b
                } else if (a == b) {

                    if (freq[a + OFFSET] >= 2) {
                        result.add(Arrays.asList(a, b, c));
                    }

                // b == c
                } else if (b == c) {

                    if (freq[b + OFFSET] >= 2) {
                        result.add(Arrays.asList(a, b, c));
                    }

                // all different
                } else {
                    result.add(Arrays.asList(a, b, c));
                }
            }
        }

        return result;
    }
}