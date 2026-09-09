import java.util.*;

class GraphNode {
    String word;
    List<GraphNode> children;

    public GraphNode(String word) {
        this.word = word;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return createGraph(beginWord, new HashSet<>(wordList), endWord);
    }

    public int createGraph(String beginWord, Set<String> wordList, String endWord) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        GraphNode root = new GraphNode(beginWord);

        wordList.remove(root.word);

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                GraphNode node = queue.poll();
                String target = node.word;

                node.children = new ArrayList<>();

                List<String> visited = new ArrayList<>();

                // build children
                for (String word : wordList) {

                    if (checkDistance(word, target)) {

                        if (word.equals(endWord)) {
                            return level + 2;
                        }

                        node.children.add(new GraphNode(word));
                        visited.add(word);
                    }
                }

                // remove visited
                for (String word : visited) {
                    wordList.remove(word);
                }

                // add children to queue
                for (GraphNode child : node.children) {
                    queue.add(child);
                }
            }

            level++;
        }

        return 0;
    }

    public boolean checkDistance(String word, String target) {

        if (word.length() != target.length()) {
            return false;
        }

        int difference = 0;

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) != target.charAt(i)) {

                difference++;

                if (difference > 1) {
                    return false;
                }
            }
        }

        return difference == 1;
    }
}