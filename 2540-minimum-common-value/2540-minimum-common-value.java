class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // two pointer problem where we assign a pointer at both the arrays
        // where we find a match that is the least common element
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            // compare first if equal return
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            // preserve the greater element
            else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        return -1;
    }
}