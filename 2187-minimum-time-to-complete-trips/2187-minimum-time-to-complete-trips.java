
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1; 
        long right =  (long) Math.pow(10, 14);

        while(left < right){
            long mid = left + (right - left ) / 2 ;
            if(canFinish(time, mid, totalTrips)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
    return right; 
}

    boolean canFinish(int [] times , long currTime, int totalTrips){
        long trips = 0;
        for (int time : times){
            trips += currTime /time;
        }
    return trips >= totalTrips;
}
}