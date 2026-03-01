import java.util.*;
import java.util.stream.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        // 1) "Valley" = index of the closest element to x (tie -> smaller value -> left)
        int valley = closestIndex(arr, x);

        // 2) Expand window in ARR indices (not ans indices)
        int L = valley, R = valley;

        while (R - L + 1 < k) {
            if (L == 0) {
                R++;
            } else if (R == n - 1) {
                L--;
            } else {
                int dl = Math.abs(arr[L - 1] - x);
                int dr = Math.abs(arr[R + 1] - x);

                // tie-break: pick left (smaller value) when equal distance
                if (dl <= dr) L--;
                else          R++;
            }
        }

        // 3) Return the slice (already sorted)
        return IntStream.range(L, R + 1).map(i -> arr[i]).boxed().toList();
    }

    // lower_bound: first index i where arr[i] >= x
    private int lowerBound(int[] arr, int x) {
        int lo = 0, hi = arr.length; // hi is exclusive
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // closest index to x, tie -> left (smaller value)
    private int closestIndex(int[] arr, int x) {
        int n = arr.length;
        int p = lowerBound(arr, x);

        if (p == 0) return 0;
        if (p == n) return n - 1;

        // candidates: p-1 and p
        int leftDist = Math.abs(arr[p - 1] - x);
        int rightDist = Math.abs(arr[p] - x);

        return (leftDist <= rightDist) ? (p - 1) : p;
    }
}