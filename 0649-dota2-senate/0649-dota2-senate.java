import java.util.*;
class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rQueue = new LinkedList<>(); 
        Deque<Integer> dQueue = new LinkedList<>();
        // build the queues
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                rQueue.add(i);
            } else{
                dQueue.add(i);
            }
        }
        while(!dQueue.isEmpty() && !rQueue.isEmpty()){
           if(rQueue.peekFirst() < dQueue.peekFirst()){
            rQueue.addLast(rQueue.pollFirst() + senate.length());        dQueue.pollFirst();
           } else{
            dQueue.add(dQueue.pollFirst() + senate.length());
            rQueue.pollFirst();
           }
        }
    return rQueue.isEmpty() ? "Dire" : "Radiant";
}
}