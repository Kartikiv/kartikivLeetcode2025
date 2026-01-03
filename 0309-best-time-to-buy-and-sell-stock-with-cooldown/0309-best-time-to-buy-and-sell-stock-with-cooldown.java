// Here we have decision dp with caching 
// States are : Buying, Selling and CoolDown
class Solution {
    /* Pair Class Overrides the hashcode so diffrent instances are same if both of the k,v 
    Are same */
    HashMap<Pair<Integer, Boolean>, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }
    public int dfs(int i, boolean state, int [] prices )
    {
        if (i >= prices.length) return 0 ;
        if(map.containsKey(new Pair<>(i, state))) return map.get(new Pair<>(i, state));
        //CoolDown
        int coolDown = dfs(i + 1, state, prices);
        if (state){
            int buying = dfs(i + 1, !state , prices) - prices[i];
            map.put(new Pair<>(i, state), Math.max(buying, coolDown));
        }else{
            int selling = dfs(i + 2 , !state , prices) + prices[i];
            map.put(new Pair<>(i, state), Math.max(selling, coolDown));
        }
    return map.get(new Pair<>(i, state)); 
    }
}
// Mark to revise Important