
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        // Same task schedule with n == 1 
        StringBuilder sb = new StringBuilder(); 
        int [] freqMap = new int[26]; 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap[b] - freqMap[a]);
        for(char c : s.toCharArray()){ 
            freqMap[c - 'a']++;
        }
        for(int i = 0; i < 26 ; i++){ 
            if(freqMap[i] > 0){
                pq.add(i);
            }
        }
        int lastOccurred = -1;
        while(!pq.isEmpty()){
            Queue<Integer> coolDown = new LinkedList<>();
        while(!pq.isEmpty()){ 
            int character = pq.poll(); 
            // check if we can add the character
            if(lastOccurred != character){ 
                sb.append((char)(character + 'a'));
                lastOccurred = character;
                freqMap[character]--;
                if(freqMap[character] > 0){ 
                    pq.add(character);
                } 
                break;      
            }else{ 
                coolDown.add(character);
            }
        }
        pq.addAll(coolDown);
        if(pq.size() == 1 && pq.peek() == lastOccurred){ 
            return "";
        }
    }
    return sb.toString(); 
}           
}
// @lc code=end

