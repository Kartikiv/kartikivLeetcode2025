import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // tails[k] = index of smallest tail for length k + 1
        int[] tails = new int[n];
        int end = 0;

        for (int i = 0; i < n; i++) {
            int left = 0, right = end;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[tails[mid]] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int position = left;

            if (position > 0) {
                parent[i] = tails[position - 1];
            }

            tails[position] = i;

            if (position == end) {
                end++;
            }
        }

        // Reconstruct LIS
        Deque<Integer> lis = new ArrayDeque<>();
        int index = tails[end - 1];

        while (index != -1) {
            lis.addFirst(nums[index]);
            index = parent[index];
        }

        System.out.println(lis.toString());
        return end;
    }
}