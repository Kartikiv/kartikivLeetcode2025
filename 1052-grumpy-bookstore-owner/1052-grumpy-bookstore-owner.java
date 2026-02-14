class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int [] crossRelation = new int [customers.length];

        for (int i = 0; i < customers.length; i++) {
            crossRelation[i] = customers[i] * (grumpy[i] == 1 ? 0 : 1);
        }
        int maxSum = 0 ;
        for (int i : crossRelation) {
            maxSum += i;
        }
        int i = 0 ; 
        int j = 0 ;
        int add = 0 ;
        int maxAdd = 0 ;
        while(j < minutes){
            add += grumpy[j] == 1 ? customers[j] : 0;
            j++;
        }
        maxAdd = add;
        while(j < customers.length){
            add -= grumpy[i] == 1 ? customers[i] : 0 ;
            i++;
            add += grumpy[j] == 1 ? customers[j] : 0;
            j++;
            maxAdd = Math.max(maxAdd, add);
        }

    return maxSum + maxAdd; 
}
}