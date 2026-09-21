import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {

        StringBuilder sb = new StringBuilder();

        int[] freqMap = new int[26];
        int mostFrequent = 0;

        for (char c : s.toCharArray()) {
            freqMap[c - 'a']++;
            mostFrequent = Math.max(
                mostFrequent,
                freqMap[c - 'a']
            );
        }

        if (mostFrequent > Math.ceilDiv(s.length(), 2)) {
            return "";
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> freqMap[b] - freqMap[a]);

        for (int i = 0; i < 26; i++) {
            if (freqMap[i] > 0) {
                pq.add(i);
            }
        }

        int lastOccurred = -1;

        while (!pq.isEmpty()) {

            int character = pq.poll();

            sb.append((char) (character + 'a'));
            freqMap[character]--;

            // Previous character has now cooled down
            if (lastOccurred != -1 &&
                freqMap[lastOccurred] > 0) {

                pq.add(lastOccurred);
            }

            // Current character enters cooldown
            lastOccurred = character;
        }

        return sb.toString();
    }
}