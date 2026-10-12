class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        // Sort by there start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] previousInterval = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (previousInterval[1] >= currentInterval[0]) {
                mergedIntervals.remove(mergedIntervals.size() - 1);
                int[] newInterval = new int[] { previousInterval[0],
                        Math.max(currentInterval[1], previousInterval[1]) };
                mergedIntervals.add(newInterval);
                previousInterval = newInterval;
            }else{
                mergedIntervals.add(currentInterval);
                previousInterval = currentInterval;
            }
        }

    return mergedIntervals.toArray(new int[mergedIntervals.size()][]); 
    }
}