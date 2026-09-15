import java.util.PriorityQueue;

class Solution {
    // this is a nlogk approach
    // we can also use quick select with dutch national flag partitioning so that
    // we can get n time complexity
    public int findKthLargest(int[] nums, int k) {
        
        return quickSelect(nums, k);
    }

    public int quickSelect(int[] arr, int k) {
        int target = arr.length - k;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int[] range = partition(arr, low, high);
            if (target < range[0]) {
                high = range[0] - 1;
            } else if (target > range[1]) {
                low = range[1] + 1;
            } else {
                return arr[target];
            }
        }

    return  -1; 
}

    public int[] partition(int[] arr, int low, int high) {
        int pivotIndex = (int) (Math.random() * ((high - low) + 1)) + low;
        int pivot = arr[pivotIndex];
        int i = low;
        while (i <= high) {
            if (arr[i] < pivot) {
                swap(arr, low, i);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, high, i);
                high--;
            } else {
                i++;
            }

        }

        return new int[] { low, high };
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}