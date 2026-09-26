import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        final int OFFSET = 100000;
        final int SIZE = 200001;

        int[] freq = new int[SIZE];

        int min = 100000;
        int max = -100000;

        // O(n)
        for (int x : nums) {
            freq[x + OFFSET]++;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // Extract distinct values in sorted order
        int distinct = 0;

        for (int x = min; x <= max; x++) {
            if (freq[x + OFFSET] != 0)
                distinct++;
        }

        int[] values = new int[distinct];
        int p = 0;

        for (int x = min; x <= max; x++) {
            if (freq[x + OFFSET] != 0)
                values[p++] = x;
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Two pointers over DISTINCT values
        for (int i = 0; i < distinct; i++) {

            int a = values[i];

            if (a > 0)
                break;

            int left = i;
            int right = distinct - 1;

            while (left <= right) {

                int b = values[left];
                int c = values[right];

                long sum = (long) a + b + c;

                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else {

                    // Check multiplicity
                    if (a == b && b == c) {

                        if (freq[a + OFFSET] >= 3)
                            ans.add(Arrays.asList(a, b, c));

                    }
                    else if (a == b) {

                        if (freq[a + OFFSET] >= 2)
                            ans.add(Arrays.asList(a, b, c));

                    }
                    else if (b == c) {

                        if (freq[b + OFFSET] >= 2)
                            ans.add(Arrays.asList(a, b, c));

                    }
                    else {
                        ans.add(Arrays.asList(a, b, c));
                    }

                    left++;
                    right--;
                }
            }
        }

        return ans;
    }
}