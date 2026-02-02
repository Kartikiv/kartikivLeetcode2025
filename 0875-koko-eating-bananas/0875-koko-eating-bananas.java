import java.util.Arrays;

class Solution {
    private int[] piles;
    private int h;

    /**
     * Finds the minimum integer eating speed K such that all banana piles
     * can be eaten within h hours.
     *
     * Problem structure:
     * - If K is sufficient (can finish within h), then any K' > K is also sufficient.
     *   This monotonicity allows binary search over K.
     *
     * Search space:
     * - Low  = 1 (slowest possible speed)
     * - High = max(piles) (fast enough to finish each pile in at most 1 hour)
     *
     * Time Complexity:
     * - O(n log M), where n = number of piles, M = max pile size
     *
     * Space Complexity:
     * - O(1) extra space
     */
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        this.h = h;

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt(); // inclusive upper bound

        // Invariant: answer is always in [low, high]
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canFinish(mid)) {
                high = mid;      // mid works; try smaller
            } else {
                low = mid + 1;   // mid doesn't work; need bigger
            }
        }
        return low;
    }

    /**
     * Returns true if eating at `speed` bananas/hour finishes within h hours.
     *
     * For each pile of size p:
     * hours needed = ceil(p / speed)
     *
     * We compute ceil(p / speed) using integer math:
     *   ceil(p / speed) = (p + speed - 1) / speed
     */
    private boolean canFinish(int speed) {
        long time = 0;

        for (int pile : piles) {
            time += (pile + speed - 1) / speed; // ceil division
            if (time > h) return false;         // early exit
        }
        return time <= h;
    }
}
