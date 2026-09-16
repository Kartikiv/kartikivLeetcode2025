import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int firstHeavyStone = queue.poll();
            int secondHeavyStone = queue.poll();
            if (firstHeavyStone != secondHeavyStone) {
                queue.offer(firstHeavyStone - secondHeavyStone);
            }
        }
        return queue.isEmpty() ?  0: queue.poll();
    }
}