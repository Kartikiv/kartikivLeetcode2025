class Solution {
    // optimal 
    public int maxProfit(int[] prices) {
        int profit = 0; 
        int minBuy = prices[0];
        for ( int i = 0; i <prices.length ; i++ ){
            minBuy = Math.min(minBuy, prices[i]);
            profit = Math.max(profit, prices[i] - minBuy);
        }
        
    return profit; }
}