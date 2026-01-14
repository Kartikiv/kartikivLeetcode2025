class Solution {
    public int[] countBits(int n)  {
        int [] dp = new int[n + 1];
        dp[0] = 0 ;
        int offset = 1;
       for(int i = 1 ; i <= n; i ++){
        if(i >= 2 && isPowerOfTwo(i)){
            offset *= 2;
        }

        dp[i] = 1 + dp[i - offset];
       }

       
   return dp; }
    public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
}