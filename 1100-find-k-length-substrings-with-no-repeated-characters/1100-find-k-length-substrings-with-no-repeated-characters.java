import java.util.*;

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length())
            return 0;
        int ans = 0;
        HashMap<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < k; i++) {
            set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(set.size() == k){
            ans = 1;
        }
        for (int i = 0, j = k; j < s.length(); j++) {
            set.put(s.charAt(j), set.getOrDefault(s.charAt(j), 0) + 1);
            int leftFreq = set.getOrDefault(s.charAt(i), 0);
            leftFreq = leftFreq - 1;

            if(leftFreq <= 0){
                set.remove(s.charAt(i));
            }else{
                set.put(s.charAt(i), leftFreq);
            }
         if(set.size() == k){
            ans += 1;
        }
        i++;
        }
        return ans;
    }
}