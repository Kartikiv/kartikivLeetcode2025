import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        // O(n)
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }

        int[] values = new int[freq.size()];
        int p = 0;

        for (int x : freq.keySet()) {
            values[p++] = x;
        }

        Arrays.sort(values);

        List<List<Integer>> ans = new ArrayList<>();

        // O(D²)
        for (int i = 0; i < values.length; i++) {

            int a = values[i];

            for (int j = i; j < values.length; j++) {

                int b = values[j];

                long cLong = -(long) a - b;

                // Since values are sorted and we require a <= b <= c
                if (cLong < b)
                    break;

                if (cLong < Integer.MIN_VALUE ||
                    cLong > Integer.MAX_VALUE)
                    continue;

                int c = (int) cLong;

                Integer countC = freq.get(c);

                // O(1) average lookup
                if (countC == null)
                    continue;

                if (a == b && b == c) {
                    if (freq.get(a) >= 3)
                        ans.add(Arrays.asList(a, b, c));

                } else if (a == b) {
                    if (freq.get(a) >= 2)
                        ans.add(Arrays.asList(a, b, c));

                } else if (b == c) {
                    if (freq.get(b) >= 2)
                        ans.add(Arrays.asList(a, b, c));

                } else {
                    ans.add(Arrays.asList(a, b, c));
                }
            }
        }

        return ans;
    }
}