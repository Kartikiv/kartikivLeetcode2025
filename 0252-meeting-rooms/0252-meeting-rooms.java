class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (p1,p2) -> Integer.compare(p1[1], p2[1]));
        int end = -1;
        for( int i = 0 ; i  < intervals.length - 1 ; i ++ ){
            int start1 = intervals[i][0];
            int end1   = intervals[i][1];
            int start2 = intervals[i + 1][0];
            if(start2 < end1){
                return false;
            }
        }
        return true;
    }
}