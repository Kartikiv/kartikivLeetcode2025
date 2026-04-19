class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        // if the input is always sorted in a decreasing way 
        // lets find the smallest index that we can form a pair with nums[i] and expand till there 
        int i = 0;
        int j = 0;
        int maxDistance = 0;
        while (i < nums1.length && j < nums2.length) {
            while (j < nums2.length - 1 && nums2[j + 1] >= nums1[i]) {
                j++;
            }
            maxDistance = Math.max(j - i, maxDistance);
            i++;
        }
        return maxDistance;
    }
}