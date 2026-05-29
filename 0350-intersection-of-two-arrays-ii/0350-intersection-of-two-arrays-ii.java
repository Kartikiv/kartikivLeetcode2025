class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap <Integer, Integer> freqMap = new HashMap<>();
        // convert nums1 to a freq map 
        for(int i = 0 ; i < nums1.length; i++){ 
            freqMap.put(nums1[i], freqMap.getOrDefault(nums1[i], 0) + 1); 
        }
        List<Integer> res = new ArrayList<>();
        // now compare and add to the res array 
        for(int i = 0; i < nums2.length; i++){ 
            if(freqMap.getOrDefault(nums2[i], 0) > 0) { 
                // decrement 
                freqMap.put(nums2[i], freqMap.get(nums2[i]) - 1); 
                res.add(nums2[i]);
            }
        }
    return res.stream().mapToInt(Integer::intValue).toArray();
    }
}