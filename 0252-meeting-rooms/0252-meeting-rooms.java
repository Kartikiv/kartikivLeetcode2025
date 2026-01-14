
// greedy Algorithm sort based on the start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0 ; i < intervals.length - 1; i++){
            int start1 = intervals[i][0];
            int start2 = intervals[i + 1][0];
            int end1 = intervals[i][1];
            int end2 = intervals[i + 1][1];
            if(start2 < end1 ) return false;

            }
    return true;}
}