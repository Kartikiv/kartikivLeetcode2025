class Solution {
    public boolean isPalindrome(String s) {
        // compare without altering the string 
        // one all non alphanumneric characters are ignored 
        // range we are looking for a - z , A - Z, 0 - 9. 
        int i = 0 ; 
        int j = s.length() - 1; 
        while(i < j){ 
            while (i < j && !checkRange(s.charAt(i))) {
                i++;
            }
            while (i < j && !checkRange(s.charAt(j))) {
                j--;
            }
            // normalize 
            char c = s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ? (char)(s.charAt(i) + 32) : s.charAt(i); 
            char d = s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' ? (char)(s.charAt(j) + 32) : s.charAt(j);
            // compare 
            if(c != d){ 
                return false;
            }
            i++; 
            j--;
        }
    return true; 
    }
    public boolean checkRange(char c){ 
        /* if(c < 48) return false; 
        if(c > 57 && c < 65) return false; 
        if (c > 90 && c < 97) return false; 
        if(c > 122) return false; */ 
        if(! Character.isLetterOrDigit(c)) return false; 
        
    return true; 
    }
}