class Solution {
    /**
     * 
     * @param n
     * @return
     * Right most bit is 1 if the number is odd 
     * we extract the right most bit and shift 
     * all the bits towards the right one time
     * and increment the counter to give the hammingWeight
     */
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            int bit = n%2;
            if(bit == 1 )count++;
            n = n >> 1;
        }
    return count; }
}


