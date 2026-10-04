class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int maxPairLength = 0;
        int runningPairLength = 0;
        int[] previousPair = new int[] { -1001, -1001 };
        for (int[] pair : pairs) {
            int previousLeft = previousPair[0];
            int previousRight = previousPair[1];
            int left = pair[0];
            int right = pair[1];
            if (previousRight < left) {
                runningPairLength++;
                maxPairLength = Math.max(maxPairLength, runningPairLength);

                previousPair = pair;
            }
        }
        return maxPairLength;
    }
}