class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        
    }

  

}

class Trie {

    TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = this.head;
        for (int i = 0; i < word.length(); i++) {
            if(node.children[word.charAt(i) - 'a'] == null) node.children[word.charAt(i) - 'a'] = new TrieNode();
            node = node.children[word.charAt(i) - 'a'];
        }

        node.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode node = this.head;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null)
                return false;
            node = node.children[word.charAt(i) - 'a'];

        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.head;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null)
                return false;
            node = node.children[prefix.charAt(i) - 'a'];

        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */