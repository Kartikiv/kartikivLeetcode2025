class Trie {
    Trie children [] ;
    int childCount = 0;
    boolean isEnd = false;
    public Trie(){
        this.children = new Trie[26];
    }
}

class Solution {
    Trie root;
    public String longestCommonPrefix(String[] strs) {
        this.root = new Trie();
        for(String s : strs){
            if (s == null || s.isEmpty()) return "";
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(root.childCount);
        while(root != null && root.childCount == 1 && !root.isEnd){
            int i = 0;
            for(; i < 26 ; i++){
                if(root.children[i] != null){
                    sb.append((char) ('a' + i));
                    break;
                }
            }
            root = root.children[i];
           
        }
        return sb.toString();
    }

    public void insert(String s){
        Trie node = root;
        for (char c : s.toCharArray()){
              int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
                node.childCount++; // increment only when a new child is created
            }

            node = node.children[idx];
        }
        node.isEnd = true;
      
    }
}