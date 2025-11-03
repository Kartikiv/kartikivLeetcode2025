
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] cand;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // enable pruning and consistent order
        this.cand = candidates;
        backtrack(0, target, new ArrayList<>());
        return ans;
    }

    private void backtrack(int start, int remain, List<Integer> cur) {
        if (remain == 0) {
            ans.add(new ArrayList<>(cur)); // already canonical order; no Set needed
            return;
        }
        for (int i = start; i < cand.length; i++) {
            int x = cand[i];
            if (x > remain)
                break; // prune
            cur.add(x);
            backtrack(i, remain - x, cur); // i (not i+1) because reuse is allowed
            cur.remove(cur.size() - 1);
        }
    }
}
