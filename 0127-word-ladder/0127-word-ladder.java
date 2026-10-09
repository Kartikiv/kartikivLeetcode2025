class Node {
    String s;
    List<Node> children;

    public Node(String s) {
        this.s = s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        return bfs(beginWord,endWord,wordList);
    }
    public int bfs(String beginWord, String endWord, List<String> wordList){
        Queue<Node> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){ 
            return 0;
        }
        queue.add(new Node(beginWord));
        wordSet.remove(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                char[] wordArr = node.s.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char original = wordArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }
                        wordArr[j] = c;
                        String word = new String(wordArr);
                        if (wordSet.contains(word)) {
                            queue.add(new Node(word));
                            if (word.equals(endWord)) {
                                return level + 1;
                            }
                            wordSet.remove(word);
                        }
                        wordArr[j] = original;

                    }
                }
            }
            
        }
        return 0;
    }
    // I need to do bfs but also at the sametime i need to create 
    // list of string which are 1 character apart 
    // how to efficiently create list of string that are one char apart
    // from a given String

}