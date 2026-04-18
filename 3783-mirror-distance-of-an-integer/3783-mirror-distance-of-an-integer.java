class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    int reverse(int x){ 
        int ans = 0;
        int mul = 1;
        while(x > 0){ 
            ans = ans * 10;
            ans = ans + x % 10;
            x /= 10;
        }
    return ans;
    }
}