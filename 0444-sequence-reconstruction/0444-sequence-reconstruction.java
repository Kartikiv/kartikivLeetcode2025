
import java.util.*;

class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        // this is fairly simple
        // we create a topological ordering
        // if it is the only topological order then we compare if we have more t
        // than one topological order we can simply return false
        // also we can see directly while we are ordering in the first place to see if
        // more than one order in possible
        // in the sense if there are more than 2 member in the queue at any given
        // instant
        // for processing than we can say that more than one topological ordering is
        // possible

        // Step 1: create a adjacency list of the sequences
        List<Integer>[] adacencyList = new ArrayList[nums.length];
        Arrays.setAll(adacencyList, n -> new ArrayList<>());
        int[] inDegree = new int[nums.length];
        for (List<Integer> sequence : sequences) {
            for (int i = 1; i < sequence.size(); i++) {
                int u = sequence.get(i - 1) - 1;
                int v = sequence.get(i) - 1;
                adacencyList[u].add(v);
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int node = queue.poll();
            order.add(node);
            for (int child : adacencyList[node]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if (nums.length != order.size())
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != order.get(i) + 1) {
                return false;
            }
        }
        return true;
    }
}