/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
       int left  = 0 ; 
        int right = 1;
        while (reader.get(right) < target) {
            left = right; 
            right <<= 1; 
        } 
        while (left <= right) {
            int mid = right + (left - right) / 2; 
            if(reader.get(mid) == target){
                return mid; 
            }
            // search the left half
            else if(reader.get(mid) > target){
                right = mid - 1; 
            }else{
                left = mid + 1;
            }
        }
    return -1 ;
         
    }
}
