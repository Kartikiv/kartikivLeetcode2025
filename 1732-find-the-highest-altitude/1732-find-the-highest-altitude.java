class Solution {
    public int largestAltitude(int[] gain) {
        int maxGain = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            maxGain = Math.max(sum, maxGain);
        }
        return maxGain < 0 ? 0 : maxGain;
    }
}