import java.util.*;

class Twitter {
    private static class TweetNode {
        int id, time;
        TweetNode next;
        TweetNode(int id, int time, TweetNode next) {
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    private Map<Integer, Set<Integer>> follows = new HashMap<>();
    private Map<Integer, TweetNode> head = new HashMap<>(); // user's tweet list head (most recent first)
    private int time = 0;

    public Twitter() {}

    private void ensureUser(int u) {
        follows.computeIfAbsent(u, k -> {
            Set<Integer> s = new HashSet<>();
            s.add(u); // self-follow
            return s;
        });
    }

    public void postTweet(int userId, int tweetId) {
        ensureUser(userId);
        // prepend to user's list
        head.put(userId, new TweetNode(tweetId, time++, head.get(userId)));
    }

    public List<Integer> getNewsFeed(int userId) {
        ensureUser(userId);

        // max-heap by time (most recent first)
        PriorityQueue<TweetNode> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        // seed heap with the head tweet of each followee
        for (int f : follows.get(userId)) {
            TweetNode h = head.get(f);
            if (h != null) pq.offer(h);
        }

        List<Integer> res = new ArrayList<>(10);
        while (!pq.isEmpty() && res.size() < 10) {
            TweetNode cur = pq.poll();
            res.add(cur.id);
            if (cur.next != null) pq.offer(cur.next); // advance that user's list
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        ensureUser(followerId);
        ensureUser(followeeId);
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot unfollow self
        ensureUser(followerId);
        ensureUser(followeeId);
        follows.get(followerId).remove(followeeId);
    }
}
