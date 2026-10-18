class Solution {
    int[] count;
    int[] nums;
    int[] indices;
    int[] temp;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        this.nums = nums;
        count = new int[n];
        indices = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int x : count) result.add(x);

        return result;
    }

    void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        int smaller = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                smaller++;
                temp[k++] = indices[j++];
            } else {
                count[indices[i]] += smaller;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            count[indices[i]] += smaller;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        for (int p = left; p <= right; p++) {
            indices[p] = temp[p];
        }
    }
}