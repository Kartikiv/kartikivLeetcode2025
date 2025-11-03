class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    int[] cand;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // enable pruning and consistent order
        this.cand = candidates;
        backtrack(0, target, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private void backtrack(int start, int remain, List<Integer> cur) {
        if (remain == 0) {
            ans.add(new ArrayList<>(cur)); // already canonical order; no Set needed
            return;
        }
        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i - 1]) continue;
            int x = cand[i];
            if (x > remain)
                break; // prune
            cur.add(x);
            backtrack(i + 1, remain - x, cur); 
            cur.remove(cur.size() - 1);
            
        }
    }
}
   