class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int L = beginWord.length();

        // 1. Build pattern map
        Map<String, List<String>> patternMap = new HashMap<>();
        List<String> allWords = new ArrayList<>(wordList);
        if (!allWords.contains(beginWord)) {
            allWords.add(beginWord);
        }

        for (String word : allWords) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap
                    .computeIfAbsent(pattern, k -> new ArrayList<>())
                    .add(word);
            }
        }

        // 2. BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        int steps = 1; // beginWord itself

        while (!queue.isEmpty()) {
            int size = queue.size();
            // each layer = one transformation step
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return steps;
                }

                // expand neighbors via patterns
                for (int pos = 0; pos < L; pos++) {
                    String pattern = word.substring(0, pos) + "*" + word.substring(pos + 1);
                    List<String> list = patternMap.get(pattern);
                    if (list == null) continue;

                    for (String next : list) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }

                    // optional optimization: clear to avoid re-traversing this bucket
                    patternMap.put(pattern, new ArrayList<>());
                }
            }
            steps++;
        }

        return 0; // no path
    }
}

/* 
1. We need connect all the words that are one letter apart from each other in a graph and then when we traverse the created graph one layer at a time 
2. We know that we are traversing the graph one layer at time so the first time we encounter the end word we know that we reached there in the shortest transformation. 
3. Till here the problem seems simple, the key trick is how do get all the words that differ by one word from a give word ?
4. can we use a prefix Trie 
5. cam we use any other structure that does this effectively ?
6. Okay we will add all the words into a tree now, for hot we search *ot, ho*, h*t. 
*/