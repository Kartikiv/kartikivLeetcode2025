class Solution {
    private static long MOD = 1_000_000_007l;

    public int numTilings(int n) {
        if(n == 0){ 
            return 0;
        }
        if(n == 1) return 1; 
        if(n == 2) return 2;
        long previous = 2;
        long secondPrevious = 1;
        long thirdPrevious = 1;
        long currentPossibillities = 0;
        for (int i = 3; i <= n; i++) {
            currentPossibillities = (2 * previous + thirdPrevious) % MOD;
            thirdPrevious = secondPrevious;
            secondPrevious = previous;
            previous = currentPossibillities;

        }
        return (int) (currentPossibillities);
    }
}