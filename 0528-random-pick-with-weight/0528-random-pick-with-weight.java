class Solution {
    int [] index;
    HashMap<Integer,Integer> map;
    public Solution(int[] w) {
       this.index = new int [10000];
       this.map = new HashMap<>();
       int sum = 0 ;

        for(int i = 0 ; i < w.length ; i++){
            sum += w[i];
            map.put(w[i], i);
        }
        int j = 0 ;
        double probabilitySum = 0 ;
        for(int i = 0 ; i < w.length ; i++){
            probabilitySum += (double) w[i] / (double) sum;
            int end = (int)(j + (((double) w[i] / (double) sum ) * 10000));
            while(j < end){
                index[j] = i;
                j++;
            }
        }
        System.out.println(probabilitySum);

    }

    public int pickIndex() {
        int num = (int)(Math.random() * 10000) - 1;
        if(num < 0) num = 0;
        return index[num];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */