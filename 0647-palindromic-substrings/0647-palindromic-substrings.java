class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        longestPalindrome(s);
        return count;
    }
    public String longestPalindrome(String s) {
        String res = "";
        String oddLen = "";
        for(int i =0 ; i < s.length(); i++){
            String ans = isPalindrome(i , i, s);
            if(oddLen.length() < ans.length()){ oddLen = ans;}
        }
        String evenLen = oddLen;
        for(int i =0 ; i < s.length(); i++){
            String ans = isPalindrome(i , i + 1, s);
            if(evenLen.length() < ans.length()){ evenLen = ans;}
        }
        
    return evenLen; 
    }
    public String isPalindrome (int i , int j , String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
    return s.substring(i + 1, j );
    }
}