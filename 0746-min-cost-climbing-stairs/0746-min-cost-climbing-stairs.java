class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dpCost = new int [n + 1];
        dpCost[0] = cost[0];
        dpCost[1] = cost[1];
        for ( int i = 2 ; i < n + 1  ; i++ ){
            // recurrence relation 
            int firstPart = (i > 0 && i < cost.length) ? cost[i] : 0;
            dpCost[i] =  firstPart + Math.min(dpCost[i - 1] , dpCost[i - 2]);
         
        }

    return dpCost[n];
    }
}