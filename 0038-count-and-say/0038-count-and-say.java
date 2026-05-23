class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        if (n == 1) {
            return "1";
        }
        
       
        String previousTerm = countAndSay(n - 1);
        
    
        return applyRLE(previousTerm);
    }
    
    
    private static String applyRLE(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        
      
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
               
                result.append(count).append(s.charAt(i - 1));
                
                count = 1;
            }
        }
        
        result.append(count).append(s.charAt(s.length() - 1));
        
        return result.toString();
    }
}