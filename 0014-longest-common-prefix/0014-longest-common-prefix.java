class Trie {
    Trie[] children;
    int childCount = 0;
    boolean isEnd = false;

    public Trie() {
        this.children = new Trie[26];
    }
}

class Solution {
    Trie root;

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        this.root = new Trie();

        for (String s : strs) {
            if (s == null || s.isEmpty()) return "";
            insert(s);
        }

        StringBuilder sb = new StringBuilder();
        Trie node = root;

        while (node != null && node.childCount == 1 && !node.isEnd) {
            int i = 0;
            for (; i < 26; i++) {
                if (node.children[i] != null) {
                    sb.append((char) ('a' + i));
                    break;
                }
            }
            node = node.children[i];
        }

        return sb.toString();
    }

    public void insert(String s) {
        Trie node = root;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            // Optional safety if input might contain non-lowercase letters:
            // if (idx < 0 || idx >= 26) return; // or throw

            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
                node.childCount++;
            }
            node = node.children[idx];
        }

        node.isEnd = true;
    }
}
