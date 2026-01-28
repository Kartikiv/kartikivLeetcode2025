
import java.util.*;
/**
 * Finds all intervals that intersect between two sorted lists of intervals.
 * 
 * Uses a two-pointer approach to traverse both interval lists simultaneously.
 * For each pair of intervals, determines if they overlap and records the intersection.
 * An intersection occurs when one interval's start is before or at the other's end.
 * 
 * @param firstList  A 2D array where each row represents an interval [start, end].
 *                   Intervals are sorted by start time.
 * @param secondList A 2D array where each row represents an interval [start, end].
 *                   Intervals are sorted by start time.
 * @return           A 2D array of all intersecting intervals, where each row is [start, end].
 *                   Returns an empty array if no intersections exist.
 * 
 * @time O(m + n) where m and n are the lengths of firstList and secondList
 * @space O(k) where k is the number of intersections in the result
 */
class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int [] > ans = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length ) {
           int start1 = firstList[p1][0], end1 = firstList[p1][1];
           int start2 = secondList[p2][0], end2 = secondList[p2][1];

            // When firstList is behind
            if(start2 > end1 ) {
                p1++;
            }
            // When secondList is behind
            else if(start1 > end2){
                p2++;
            } else{
                ans.add(new int []{Math.max(start1, start2), Math.min(end1, end2)});

                if(end1 > end2){
                    p2++;
                }
                else{
                    p1++;
                }
            }
        }
        
    return ans.toArray(int[][]::new);}
}