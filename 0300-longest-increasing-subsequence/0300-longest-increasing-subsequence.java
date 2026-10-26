class Solution {
    public int lengthOfLIS(int[] nums) {
        int parent[] = new int[nums.length];
        Arrays.fill(parent, -1);
        int[] tails = new int[nums.length];
        int start = 0;
        int end = 1;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // search insert postion 
            int left = start;
            int right = end;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int postion = right;
            tails[postion] = nums[i];
            if (end == postion) {
                end++;
            }
        }
    return end - start; }
}