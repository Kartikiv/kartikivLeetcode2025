class Solution {
    public int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        words.remove(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int k = 0; k < levelSize; k++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return level;
                }

                char[] chars = current.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;

                        String next = new String(chars);

                        if (words.contains(next)) {
                            queue.add(next);
                            words.remove(next);
                        }
                    }

                    chars[i] = original;
                }
            }

            level++;
        }

        return 0;
    }
}