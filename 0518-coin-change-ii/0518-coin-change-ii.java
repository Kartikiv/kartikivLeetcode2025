class Solution {
    public int change(int amount, int[] coins) {
      int [] below = new  int [ amount + 1];
      int [] top = new  int [ amount + 1];  
      top   [0] = 1;
      below [0] = 1;
      for(int i = coins.length - 1 ; i >= 0; i--){
        top[0] = 1; 
           for(int j = 1 ; j <= amount ; j++){
                top[j] = below[j];  
                int index = j - coins[i];
                if(index >= 0 && index <= amount){
                    top[j] += top[index];
                }
           }
          below = top;
          top = new int[amount + 1];
      }  
    return below[amount]; }
}