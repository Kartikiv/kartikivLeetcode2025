class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        normalizeDominoes(dominoes);
        int count = 0;
        HashMap<Pair<Integer,Integer>, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            map.put(new Pair<>(dominoe[0], dominoe[1]), map.getOrDefault(new Pair<>(dominoe[0], dominoe[1]), 0) + 1);
            
        }
        for(Pair<Integer,Integer> key : map.keySet()){ 
            int freq = map.get(key);
            count += (freq * (freq - 1)) / 2;
        }
        return count;
    }

    public void normalizeDominoes(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
        }
    }
}