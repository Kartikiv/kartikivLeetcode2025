/* 
1. I can bucket then and get the k most frequent element and the time complexity will be o n.
2. We create a bucket of length of the array as frequency does not exceed the length.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, 
                freqMap.getOrDefault(num, 0)+ 1);
        }

        List<Integer> [] bucket = new List[nums.length + 1];

        for(int key : freqMap.keySet()){
            if(bucket[freqMap.get(key)] == null) {
                bucket[freqMap.get(key)] = new ArrayList<>();
            }
            bucket[freqMap.get(key)].add(key);
        }
        int[] ans = new int[k];
        int idx = 0;
        for (int f = bucket.length - 1; f >= 0 && idx < k; f--) {
        if (bucket[f] == null) continue;
        for (int num : bucket[f]) {
            ans[idx++] = num;
            if (idx == k) break;
        }
        }
    return ans;
}
    }
