class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }

 
}

class WordDictionary {
    TrieNode head;

    public WordDictionary() {
        this.head = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = this.head;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];

        }
        node.isEnd = true;

    }

    // Here we need to implement bactracking
    public boolean search(String word) {
        TrieNode node = this.head;
        char[] wordArr = word.toCharArray();
        return helper(node, 0, wordArr);
        
    }

    public boolean helper(TrieNode node, int index, char[] wordArr) {
        if (index == wordArr.length) {
            return node.isEnd;
        }

        if (wordArr[index] == '.') {
            for (TrieNode child : node.children) {
                if (child != null && helper(child, index + 1, wordArr)) {
                    return true;
                }
            }
            return false;
        }

        else {
            if (node.children[wordArr[index] - 'a'] == null) {
                return false;
            }
            return helper(node.children[wordArr[index] - 'a'], index + 1, wordArr);
        }

    }
}

/* public boolean search(String word) {
    TrieNode node = this.head;
    for( char c : word.toCharArray() ){
        if(c != '.' &&  node.children[c - 'a'] == null) return false;
        if(c != '.') node = node.children[c - 'a'];
    }
return node.isEnd;}
} */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */