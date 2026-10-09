class Solution {

    public int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();

        start.add(beginWord);
        end.add(endWord);

        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        int level = 1;

        while (!start.isEmpty() && !end.isEmpty()) {

            // Always expand smaller frontier
            if (start.size() > end.size()) {
                Set<String> temp = start;
                start = end;
                end = temp;
            }

            Set<String> next = new HashSet<>();

            for (String current : start) {

                char[] arr = current.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        arr[i] = c;

                        String neighbor = new String(arr);

                        // The two BFS searches meet
                        if (end.contains(neighbor)) {
                            return level + 1;
                        }

                        if (wordSet.contains(neighbor)) {

                            next.add(neighbor);

                            // globally mark consumed
                            wordSet.remove(neighbor);
                        }
                    }

                    arr[i] = original;
                }
            }

            start = next;
            level++;
        }

        return 0;
    }
}