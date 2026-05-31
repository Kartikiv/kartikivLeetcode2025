class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!minHeap.isEmpty() && start >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.offer(end);
        }

        return minHeap.size();
    }
}