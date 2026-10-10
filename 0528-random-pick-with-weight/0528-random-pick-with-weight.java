class Solution {
    int totalWeight;
    int[] weight;

    public Solution(int[] w) {
        weight = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i];
            weight[i] = totalWeight;
        }
    }

    public int pickIndex() {
        // target is in [0, totalWeight - 1]
        int target = (int) (Math.random() * totalWeight);

        int low = 0;
        int high = weight.length - 1;

        // Find first prefix sum > target
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (weight[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}