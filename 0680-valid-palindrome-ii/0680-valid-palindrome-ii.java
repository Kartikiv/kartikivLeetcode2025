class Solution {
    String s;
    public boolean validPalindrome(String s) {
        this.s = s;
        int i =0; 
        int j = s.length() - 1; 
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isValid(i + 1, j) || isValid(i, j - 1);
            }
            i++;
            j--;
        }
    return  true;
}

    public boolean isValid(int i, int j){
        while(i < j){
           if(s.charAt(i) != s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
return  true; }
}