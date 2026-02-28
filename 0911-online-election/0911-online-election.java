
import java.util.HashMap;

class TopVotedCandidate {
    HashMap<Integer, Integer> map = new HashMap<>();
    int [] times ;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int[] votes = new int[persons.length];
        int maxCandiate = 0;
        for (int i = 0; i < votes.length; i++) {
            votes[persons[i]]++;
            if (votes[maxCandiate] <= votes[persons[i]]) {
                maxCandiate = persons[i];
            }
            map.put(times[i], maxCandiate);
        }
    }

    public int q(int t) {

    return map.get(upperBoundSearch(times, t)); 
}
   int upperBoundSearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2 ;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
    return nums[left]; 
}
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */