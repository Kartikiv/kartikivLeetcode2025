class Solution {
    public int minMoves(int[] nums) {
        int maxElement = Arrays.stream(nums).max().getAsInt(); 
        int moves = 0; 
        for(int num : nums){ 
            moves += maxElement - num;
        }
    return moves; 
    }
}