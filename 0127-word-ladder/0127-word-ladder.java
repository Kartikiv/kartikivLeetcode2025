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

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        words.remove(beginWord);
        words.remove(endWord);

        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller side
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) {
                            continue;
                        }

                        chars[i] = c;

                        String next = new String(chars);

                        // Two searches have met
                        if (endSet.contains(next)) {
                            return level + 1;
                        }

                        if (words.contains(next)) {
                            nextLevel.add(next);
                            words.remove(next);
                        }
                    }

                    chars[i] = original;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}