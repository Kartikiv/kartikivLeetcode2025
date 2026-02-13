import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int j = 0 ;
        int i = 0 ; 
        int maxAns = 0 ;
        while (j < fruits.length) {
            freqMap.put(fruits[j], freqMap.getOrDefault(fruits[j], 0) + 1);
            while (freqMap.size() > 2) {
                if(freqMap.getOrDefault(fruits[i], 0) > 1){
                    freqMap.put(fruits[i], freqMap.getOrDefault(fruits[i], 0) - 1);
                }else{
                    freqMap.remove(fruits[i]);
                }
                i++;
            }
            if(freqMap.size() <= 2){
                maxAns = Math.max(maxAns, j - i + 1);
            }
            j++;
        }
    return maxAns;
}
}