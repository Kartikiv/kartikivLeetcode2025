class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        return slidingWindowAtmostK(nums, k) - slidingWindowAtmostK(nums, k - 1);
    }

    int slidingWindowAtmostK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int numOdd = 0;
        int count = 0;
        while (j < nums.length) {
            if (isOdd(nums[j])) {
                numOdd++;
            }

            while (i <= j && numOdd > k) {
                if (isOdd(nums[i])) {
                    numOdd--;
                }
                i++;
            }
            count += j - i + 1;
            j++;

        }
        return count;
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

}