import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        ExecutorService executor = null;

        try {
            if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
                return false;
            }

            int total = 0;
            for (int num : nums) {
                total += num;
            }

            if (total % k != 0) {
                return false;
            }

            int target = total / k;

            Arrays.sort(nums);
            reverse(nums);

            if (nums[0] > target) {
                return false;
            }

            int[] buckets = new int[k];
            buckets[0] = nums[0]; // symmetry breaking

            AtomicBoolean found = new AtomicBoolean(false);

            int threads = Math.max(1, Runtime.getRuntime().availableProcessors());
            executor = Executors.newFixedThreadPool(threads);
            CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executor);

            List<State> frontier = new ArrayList<>();
            buildFrontier(nums, 1, buckets, target, frontier, 2);

            if (frontier.isEmpty()) {
                return false;
            }

            int submitted = 0;
            for (State state : frontier) {
                completionService.submit(() -> dfs(state.index, nums, state.buckets, target, found));
                submitted++;
            }

            for (int i = 0; i < submitted; i++) {
                Future<Boolean> future = completionService.take();
                if (future.get()) {
                    found.set(true);
                    return true;
                }
            }

            return false;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } catch (ExecutionException e) {
            return false;
        } finally {
            if (executor != null) {
                executor.shutdownNow();
            }
        }
    }

    private boolean dfs(int index, int[] nums, int[] buckets, int target, AtomicBoolean found) {
        if (found.get()) {
            return false;
        }

        if (index == nums.length) {
            for (int sum : buckets) {
                if (sum != target) {
                    return false;
                }
            }
            found.set(true);
            return true;
        }

        int num = nums[index];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < buckets.length; i++) {
            if (found.get()) {
                return false;
            }

            if (seen.contains(buckets[i])) {
                continue;
            }

            if (buckets[i] + num > target) {
                continue;
            }

            seen.add(buckets[i]);
            buckets[i] += num;

            if (dfs(index + 1, nums, buckets, target, found)) {
                return true;
            }

            buckets[i] -= num;

            if (buckets[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void buildFrontier(int[] nums, int index, int[] buckets, int target, List<State> frontier, int splitDepth) {
        if (splitDepth == 0 || index == nums.length) {
            frontier.add(new State(index, Arrays.copyOf(buckets, buckets.length)));
            return;
        }

        int num = nums[index];
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < buckets.length; i++) {
            if (seen.contains(buckets[i])) {
                continue;
            }

            if (buckets[i] + num > target) {
                continue;
            }

            seen.add(buckets[i]);
            buckets[i] += num;

            buildFrontier(nums, index + 1, buckets, target, frontier, splitDepth - 1);

            buckets[i] -= num;

            if (buckets[i] == 0) {
                break;
            }
        }
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private static class State {
        int index;
        int[] buckets;

        State(int index, int[] buckets) {
            this.index = index;
            this.buckets = buckets;
        }
    }
}