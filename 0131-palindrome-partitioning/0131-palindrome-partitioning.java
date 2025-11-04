
class Solution {
    List<List<String>> ans = new ArrayList<>();
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        this.n = s.length();
        dfs(0, new ArrayList<>());
        return ans;
    }

    private void dfs(int i, List<String> path) {
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPal(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPal(int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
