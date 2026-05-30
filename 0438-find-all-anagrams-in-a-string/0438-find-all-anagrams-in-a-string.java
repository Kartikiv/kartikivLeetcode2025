class Solution {
   int[] charPrimes = {
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
    31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
    73, 79, 83, 89, 97, 101, 103, 107
};

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
        long pHashCode = 0;
        long sHashCode = 0; 
        for(char c : p.toCharArray()){ 
            pHashCode += calcuteHashCode(c);
        } 
        List<Integer> ans = new ArrayList<>();
        // pointer to the begining 
        int i = 0 ; 
        int j = p.length(); // pointer to the end 
        for(int k = 0; k < p.length(); k++) {
            sHashCode += calcuteHashCode(s.charAt(k));
        }
        if(sHashCode == pHashCode){ 
                ans.add(i);
            }
        while (j < s.length()) {
            
            // move the window forward 
            sHashCode -= calcuteHashCode(s.charAt(i));
            sHashCode += calcuteHashCode(s.charAt(j));
            i++;
            j++;
            if(sHashCode == pHashCode){ 
                ans.add(i);
            }

        }
    return ans; 
    }

    public int calcuteHashCode(char c){ 
        return c * charPrimes[c - 'a'];
    }
}