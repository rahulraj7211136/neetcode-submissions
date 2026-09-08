class Twitter {
    private Map<Integer, User>mp;
    private int count;
    class Tweet {
        int time;
        int tweetId;
        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = count++;
        }
    }
    class User {
        int userId;
        HashSet<Integer> followers;
        List<Tweet> tweets;
        User(int userId) {
            this.userId = userId;
            this.followers = new HashSet<>();
            this.tweets = new LinkedList<>();
            this.followers.add((Integer)userId);
        }
        public void addTweet(Tweet t) {
            this.tweets.add(0, t);
        }
        public void addFollower(int follower) {
            this.followers.add(follower);
        }
        public void removeFollower(int follower) {
            this.followers.remove(follower);
        }
    }

    public Twitter() {
        this.mp = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!mp.containsKey(userId)) {
            mp.put(userId, new User(userId));
        }
        User user = mp.get(userId);
        user.addTweet(new Tweet(tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> q = new PriorityQueue<>((a,b) -> b.time - a.time);
        HashSet<Integer> followers = mp.get(userId).followers;
        for(Integer x : followers) {
            User u = mp.get(x);
            for(int i=0; i < Math.min(10, u.tweets.size()); i++) {
                q.add(u.tweets.get(i));
            }
        }
        int z = 10;
        while(!q.isEmpty() && z != 0) {
            Tweet t = q.poll();
            ans.add(t.tweetId);
            z--;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!mp.containsKey(followerId)) {
            mp.put(followerId, new User(followerId));
        }
        if(!mp.containsKey(followeeId)) {
            mp.put(followeeId, new User(followeeId));
        }
        User user = mp.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!mp.containsKey(followerId) || !mp.containsKey(followeeId)) {
            return;
        }
        User user = mp.get(followerId);
        user.removeFollower(followeeId);
    }
}
