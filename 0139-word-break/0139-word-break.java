class Solution {
    // leetcode
    public boolean wordBreak(String s, List<String> wordDict) {
    int length = s.length();
    HashSet<String> wordSet = new HashSet<>(wordDict);
    boolean [] dp = new boolean[length + 1];
    dp[0] = true;

    for (int i = 1 ; i < length + 1 ; i++){
        for(int j = 0 ; j < i ; j++){
            if(dp[j] && wordSet.contains(s.substring(j , i))){
                dp[i] = true;
            }
        }
    }
    
    return dp[length];
    }
}