import java.util.*;

class Solution {
    static class Job {
        int time;
        int duration;
        int index;

        Job(int time, int duration, int index) {
            this.time = time;
            this.duration = duration;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(jobs, (a, b) -> a.time != b.time ? a.time - b.time : a.index - b.index);

        PriorityQueue<Job> ready = new PriorityQueue<>((a, b) -> {
            if (a.duration != b.duration) return a.duration - b.duration;
            return a.index - b.index;
        });

        int[] order = new int[n];
        int pos = 0;
        int done = 0;
        long currentTime = 0;

        while (done < n) {
            if (ready.isEmpty() && pos < n && currentTime < jobs[pos].time) {
                currentTime = jobs[pos].time;
            }

            while (pos < n && jobs[pos].time <= currentTime) {
                ready.add(jobs[pos]);
                pos++;
            }

            Job job = ready.poll();
            order[done++] = job.index;
            currentTime += job.duration;
        }

        return order;
    }
}

        