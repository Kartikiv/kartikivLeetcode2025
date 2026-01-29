

class Solution {
    String s;
    int k ; 
    public int characterReplacement(String s, int k) {
        this.s = s;
        this.k = k;
        int maxLen = 1;
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int [] charMap = new int[26];
        while(j < s.length()){
            
                charMap[s.charAt(j) - 'A'] = charMap[s.charAt(j) - 'A'] + 1;
                maxFreq = Math.max(maxFreq, charMap[s.charAt(j) - 'A']);
                
                
                while(!isValidWindow(i, j, maxFreq)){
                    charMap[s.charAt(i) - 'A']--;
                    i++;
                    int temp = 1; 
                    for(int freq : charMap){
                        temp =  Math.max(freq, temp);
                    }
                    maxFreq = temp;
                }
                maxLen = Math.max(maxLen, (j - i) + 1);
            j++;
        }
    return maxLen; 
}

     boolean isValidWindow(int i , int j , int maxFreq){
        return (j - i) + 1 - maxFreq <= k;
    }
}