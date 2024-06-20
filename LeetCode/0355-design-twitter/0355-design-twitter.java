import java.time.LocalDateTime;
import java.util.*;

class Twitter {
    class Tweet implements Comparable<Tweet> {
        int id;
        LocalDateTime createdTime;
        int creatorId;

        @Override
        public int compareTo(Tweet o) {
            // 최신순 정렬
            return o.createdTime.compareTo(this.createdTime);
        }
    }

    class User {
        int id;
        Set<Integer> followers;
        Set<Integer> followees;
        PriorityQueue<Tweet> tweets;

        public User() {
            followers = new HashSet<>();
            followees = new HashSet<>();
            tweets = new PriorityQueue<>();
        }
    }

    Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // userId에 해당하는 User에 tweetId 추가
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User());
        }
        User user = userMap.get(userId);
        Tweet newTweet = new Tweet();
        newTweet.id = tweetId;
        newTweet.createdTime = LocalDateTime.now();
        newTweet.creatorId = userId;
        user.tweets.add(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        // follow한 사람들과 자기가 쓴 글 중 최근 10개
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }

        User user = userMap.get(userId);
        PriorityQueue<Tweet> feed = new PriorityQueue<>(user.tweets);

        for (int followeeId : user.followees) {
            User followee = userMap.get(followeeId);
            if (followee != null && followee.tweets != null) {
                feed.addAll(followee.tweets);
            }
        }

        for (int i = 0; i < 10 && !feed.isEmpty(); i++) {
            result.add(feed.poll().id);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        // followerId가 followeeId를 follow
        if (followerId == followeeId) return;
        
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User());
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User());
        }

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.add(followeeId);
        followee.followers.add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        // followerId가 followeeId를 unfollow
        if (followerId == followeeId || !userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.remove(followeeId);
        followee.followers.remove(followerId);
    }
}
