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

            int n = nums.length;
            int fullMask = (1 << n) - 1;

            AtomicBoolean found = new AtomicBoolean(false);
            ConcurrentHashMap<Integer, Boolean> memo = new ConcurrentHashMap<>();

            List<State> frontier = new ArrayList<>();
            buildFrontier(nums, 0, 0, target, 3, frontier);
            // split first few levels before parallel search

            if (frontier.isEmpty()) {
                return false;
            }

            int threads = Math.max(1, Runtime.getRuntime().availableProcessors());
            executor = Executors.newFixedThreadPool(threads);
            CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executor);

            int submitted = 0;
            for (State state : frontier) {
                completionService.submit(() ->
                    dfs(nums, state.mask, state.currSum, target, fullMask, memo, found)
                );
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

    private boolean dfs(
        int[] nums,
        int mask,
        int currSum,
        int target,
        int fullMask,
        ConcurrentHashMap<Integer, Boolean> memo,
        AtomicBoolean found
    ) {
        if (found.get()) {
            return false;
        }

        if (mask == fullMask) {
            boolean ok = (currSum == 0);
            if (ok) {
                found.set(true);
            }
            return ok;
        }

        Boolean cached = memo.get(mask);
        if (cached != null) {
            return cached;
        }

        for (int i = 0; i < nums.length; i++) {
            if (found.get()) {
                return false;
            }

            if ((mask & (1 << i)) != 0) {
                continue;
            }

            if (currSum + nums[i] > target) {
                continue;
            }

            int nextMask = mask | (1 << i);
            int nextSum = (currSum + nums[i]) % target;

            if (dfs(nums, nextMask, nextSum, target, fullMask, memo, found)) {
                memo.put(mask, true);
                return true;
            }

            if (currSum == 0) {
                break;
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        memo.put(mask, false);
        return false;
    }

    private void buildFrontier(
        int[] nums,
        int mask,
        int currSum,
        int target,
        int depth,
        List<State> frontier
    ) {
        if (depth == 0 || mask == (1 << nums.length) - 1) {
            frontier.add(new State(mask, currSum));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }

            if (currSum + nums[i] > target) {
                continue;
            }

            int nextMask = mask | (1 << i);
            int nextSum = (currSum + nums[i]) % target;

            buildFrontier(nums, nextMask, nextSum, target, depth - 1, frontier);

            if (currSum == 0) {
                break;
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
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
        int mask;
        int currSum;

        State(int mask, int currSum) {
            this.mask = mask;
            this.currSum = currSum;
        }
    }
}