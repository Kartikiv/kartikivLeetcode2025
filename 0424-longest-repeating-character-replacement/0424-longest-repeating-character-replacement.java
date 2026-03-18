class Solution {
    public int characterReplacement(String s, int k) {
        // Step 1 : expand till the window condition is meet we need to maintain a window 
		// where there are atmost k distinct character 
	
		int i = 0 ; 
		int j = 0 ; 
		int maxWindow = 0; 
        int maxFreq = 0 ;
        int [] map = new int[26]; 
		while(j < s.length()){
		// put in the map 
            map[s.charAt(j) - 'A']++;
            maxFreq = Math.max(map[s.charAt(j) - 'A'], maxFreq);

		
		// Shrink the window if invalid
        if(j - i + 1 - maxFreq > k){
            map[s.charAt(i) - 'A']--;
            i++;
        }
			
		// compute the maxWindow
		// we are computing here as shrinking makes the window valid
		maxWindow = Math.max(maxWindow, j - i + 1);
        j++;
		}
    return maxWindow; 
	}
}