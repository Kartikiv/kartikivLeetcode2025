import java.util.ArrayList;
import java.util.List;

class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // non-null if this node represents a complete word
    }

    private char[][] board;
    private int m, n;
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        // 1. Build Trie from words
        TrieNode root = buildTrie(words);

        // 2. DFS from each cell, walking the Trie
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = w; // store full word at the end node
        }
        return root;
    }

    private void dfs(int i, int j, TrieNode node) {
        // bounds
        if (i < 0 || j < 0 || i >= m || j >= n) return;

        char c = board[i][j];
        // visited or no matching child
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        // found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        // mark visited
        board[i][j] = '#';

        // explore neighbors
        dfs(i + 1, j, node);
        dfs(i - 1, j, node);
        dfs(i, j + 1, node);
        dfs(i, j - 1, node);

        // backtrack
        board[i][j] = c;
    }
}
