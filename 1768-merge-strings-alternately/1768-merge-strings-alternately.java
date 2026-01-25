class Solution {
    public String mergeAlternately(String word1, String word2) {
         boolean turn =  true;
         StringBuilder sb = new StringBuilder();
         int i = 0;
         int j = 0; 
         while(i < word1.length() || j < word2.length()){
             if(i >=  word1.length()) turn = false;
             if(j >= word2.length()) turn = true;
             if(turn){
                sb.append(word1.charAt(i));
                i++;
                turn = !turn;
             } else{
                sb.append(word2.charAt(j));
                j++;         
                turn = !turn;      
             }
         }
    return sb.toString(); 
}
}
// Turnstile machine 