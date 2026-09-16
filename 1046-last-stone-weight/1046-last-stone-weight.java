class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length <= 1) return stones[0];
        int [] weightOrder = new int [1001];
        for (int stone : stones) {
            weightOrder[stone]++;
        }
        int stonesInQueue = stones.length;
        int j = 1000; 
        while(stonesInQueue > 1){ 
            int firstHeavyStone = -1;
            int secondHeavyStone = -1;
            while(j >= 0 && weightOrder[j] == 0){
                j--;
            }
            weightOrder[j]--;
            firstHeavyStone = j;
            stonesInQueue--;
            while(j >= 0 && weightOrder[j] == 0){
                j--;
            }
            weightOrder[j]--;
            secondHeavyStone = j; 
            stonesInQueue--;
            if(firstHeavyStone != secondHeavyStone){ 
                weightOrder[firstHeavyStone - secondHeavyStone]++;
                stonesInQueue++;
                if(j < firstHeavyStone - secondHeavyStone){
                    j = firstHeavyStone - secondHeavyStone;
                }
            }
        }
        while (j >= 0 && weightOrder[j] == 0) {
            j--;
        }
        return stonesInQueue == 0 ? 0 : j;
    }
}