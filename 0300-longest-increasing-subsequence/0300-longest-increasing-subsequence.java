
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        int[] parent = new int[nums.length];
        int[] tailIndex = new int[nums.length];

        Arrays.fill(parent, -1);

        for (int i = 0; i < nums.length; i++) {

            int pos;

            if (tails.isEmpty() ||
                tails.get(tails.size() - 1) < nums[i]) {

                pos = tails.size();
                tails.add(nums[i]);

            } else {
                int low = 0;
                int high = tails.size() - 1;

                while (low < high) {
                    int mid = low + (high - low) / 2;

                    if (tails.get(mid) < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                pos = low;
                tails.set(pos, nums[i]);
            }

            // The predecessor belongs to the previous length
            if (pos > 0) {
                parent[i] = tailIndex[pos - 1];
            }

            // Store original index for this length
            tailIndex[pos] = i;
        }

        int[] result = new int[tails.size()];

        if (tails.isEmpty()) return 0;

        int index = tailIndex[tails.size() - 1];
        int i = result.length - 1;

        while (index != -1) {
            result[i--] = nums[index];
            index = parent[index];
        }

        System.out.println(Arrays.toString(result));

        return tails.size();
    }
}
