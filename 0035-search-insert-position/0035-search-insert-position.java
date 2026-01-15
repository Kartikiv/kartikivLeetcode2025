class Solution {
    public int searchInsert(int[] nums, int target) {
        
    return floor(nums, target) + 1;
    }

    int floor(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    int ans = -1;

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;

        if (arr[mid] < target) {
            ans = mid;   // candidate
            lo = mid + 1;     // try for a bigger one
        } else {
            hi = mid - 1;
        }
    }
    return ans;
}
}