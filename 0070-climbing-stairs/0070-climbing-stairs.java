class Solution {
    public int climbStairs(int n) {
        int secondPreviousStep = 1;
        int firstPreviousStep = 1;
        if(n == 1) return firstPreviousStep;
        int ans = 0;

        
        for (int i = 2; i < n + 1; i++) {
            ans = firstPreviousStep + secondPreviousStep;
            secondPreviousStep = firstPreviousStep;
            firstPreviousStep = ans;
        }

    return ans;
    }
}