class Solution {
    int [] probalityDistribution;
    int maxWeight ;    
    public Solution(int[] w) {
        this.probalityDistribution = new int [w.length]; 
        int sum = 0 ; 
        for (int i = 0; i < w.length; i++) {
            sum += w[i]; 
            probalityDistribution[i] = sum ;
        }
        // assign the max weight
        this.maxWeight = sum; 

    }
    
    public int pickIndex() {
       int target = (int) (Math.random() * maxWeight) + 1;
        int left = 0 ; 
        int right = probalityDistribution.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;  
            if(probalityDistribution[mid] >= target){
                right = mid;
            }else{
                left = mid + 1; 
            }
        }

    return right; }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */