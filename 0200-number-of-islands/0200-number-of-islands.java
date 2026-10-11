class Solution {

    public int numIslands(char[][] grid) {

        Set<Character> islandSet = new HashSet<>();
        Map<Character, Character> parent = new HashMap<>();

        char islandNo = '2';

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] != '1') {
                    continue;
                }

                char top = '0';
                char left = '0';

                if (i > 0 && grid[i - 1][j] != '0') {
                    top = find(grid[i - 1][j], parent);
                }

                if (j > 0 && grid[i][j - 1] != '0') {
                    left = find(grid[i][j - 1], parent);
                }

                // No processed land neighbor
                if (top == '0' && left == '0') {

                    grid[i][j] = islandNo;

                    parent.put(islandNo, islandNo);
                    islandSet.add(islandNo);

                    islandNo++;
                }

                // Only left exists
                else if (top == '0') {
                    grid[i][j] = left;
                }

                // Only top exists
                else if (left == '0') {
                    grid[i][j] = top;
                }

                // Same island
                else if (top == left) {
                    grid[i][j] = top;
                }

                // Two different islands just connected
                else {

                    char keep = top < left ? top : left;
                    char remove = top < left ? left : top;

                    parent.put(remove, keep);

                    grid[i][j] = keep;

                    islandSet.remove(remove);
                }
            }
        }

        return islandSet.size();
    }

    private char find(char x, Map<Character, Character> parent) {

        if (parent.get(x) == x) {
            return x;
        }

        char root = find(parent.get(x), parent);
        parent.put(x, root);

        return root;
    }
}