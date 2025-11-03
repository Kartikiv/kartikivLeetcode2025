class User {
    int userId;
    Set<Integer> follows;

    public User(int id) {
        follows = new HashSet<>();
        follows.add(id);
        userId = id;
    }
}

class Tweet {
    int tweetId;
    int userId;
    int timeStamp;

    public Tweet(int id, int userId, int stamp) {
        this.tweetId = id;
        this.timeStamp = stamp;
        this.userId = userId;
    }
}

class Twitter {
    List<Tweet> tweets;
    HashMap<Integer, User> users;
    int timeStamp;

    public Twitter() {
        this.tweets = new ArrayList<>();
        this.users = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        tweets.add(new Tweet(tweetId, userId, timeStamp));
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        List<Integer> ans = new ArrayList<>();
        Set<Integer> follows = users.get(userId).follows;
        int j = 0 ;
        for (int i = tweets.size()-1 ;j < 10 && i >= 0 ; i--){
            Tweet tweet = tweets.get(i);
            if(follows.contains(tweet.userId)){
                ans.add(tweet.tweetId);
                j++;
            }
        }
    return ans;}

    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).follows.add(followeeId);
        
    }

    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }
        if(!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }
        users.get(followerId).follows.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */