import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;   // no cooldown → run back-to-back

        // 1) Count frequencies
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        // 2) Max-heap of remaining counts
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int f : freq) if (f > 0) pq.offer(f);

        int time = 0;
        final int CYCLE = n + 1;

        // 3) Process in cycles of up to (n+1) different tasks
        while (!pq.isEmpty()) {
            int executed = 0;
            List<Integer> pending = new ArrayList<>(CYCLE);

            for (int i = 0; i < CYCLE && !pq.isEmpty(); i++) {
                int f = pq.poll() - 1;   // run once
                executed++;
                if (f > 0) pending.add(f);
            }

            // count the actual work done this cycle
            time += executed;

            // put back the tasks that still remain
            for (int f : pending) pq.offer(f);

            // if tasks remain but we didn’t fill the whole cycle, we must idle
            if (!pq.isEmpty() && executed < CYCLE) {
                time += (CYCLE - executed);
            }
        }

        return time;
    }
}
