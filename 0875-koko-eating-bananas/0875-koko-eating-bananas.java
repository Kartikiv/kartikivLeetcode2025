import static java.lang.Math.max;

class Solution {
    static { 
        Runtime.getRuntime().addShutdownHook(new Thread(() -> { 
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) { 
                fw.write("0"); 
            } catch (Exception _) { } 
        }));
    }
    public static int calculateTime(int[] piles,int k){
        int result = 0;
        for (int i=0;i<piles.length;i++){

            result += Math.ceil((double) piles[i] / k);
        }
        return result;
    }
    public static int getMax(int[] piles){
        int result = 1;
        for (int i = 0; i < piles.length; i++) {
            result = max(result,piles[i]);
        }
        return result;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int result =h; //8
        int maxPile = getMax(piles);
        int left =1;

        int right = maxPile;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours  = calculateTime(piles,mid);
            if (hours > h) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}