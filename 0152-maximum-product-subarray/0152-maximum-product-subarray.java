class Solution {
    public int maxProduct(int[] nums) {
        int result = Arrays.stream(nums).max().getAsInt();

        int maxSoFar = 1;
        int minSoFar = 1;

        for (int num : nums) {
            if (num == 0) {
                maxSoFar = 1;
                minSoFar = 1;
                continue;
            }

            int prevMax = maxSoFar;
            int prevMin = minSoFar;

            maxSoFar = max(num * prevMax, num * prevMin, num);
            minSoFar = min(num * prevMax, num * prevMin, num);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}