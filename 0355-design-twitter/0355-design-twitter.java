import java.time.LocalDateTime;
import java.util.*;

class Twitter {
    class Tweet implements Comparable<Tweet> {
        int id;
        LocalDateTime createdTime;
        int creatorId;

        Tweet(int id, int creatorId) {
            this.id = id;
            this.creatorId = creatorId;
            this.createdTime = LocalDateTime.now();
        }

        @Override
        public int compareTo(Tweet o) {
            // 최신순 정렬
            return o.createdTime.compareTo(this.createdTime);
        }
    }

    class User {
        int id;
        Set<Integer> followees; // 내가 팔로우한 사람들
        List<Tweet> tweets;

        User(int id) {
            this.id = id;
            this.followees = new HashSet<>();
            this.tweets = new ArrayList<>();
        }

        void postTweet(int tweetId) {
            Tweet newTweet = new Tweet(tweetId, this.id);
            this.tweets.add(newTweet);
        }

        void follow(int followeeId) {
            this.followees.add(followeeId);
        }

        void unfollow(int followeeId) {
            this.followees.remove(followeeId);
        }

        List<Integer> getNewsFeed(Map<Integer, User> userMap) {
            List<Integer> result = new ArrayList<>();
            PriorityQueue<Tweet> feed = new PriorityQueue<>(tweets);

            for (int followeeId : followees) {
                if (userMap.containsKey(followeeId)) {
                    feed.addAll(userMap.get(followeeId).tweets);
                }
            }

            int count = 0;
            while (!feed.isEmpty() && count < 10) {
                result.add(feed.poll().id);
                count++;
            }

            return result;
        }
    }

    Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        return userMap.get(userId).getNewsFeed(userMap);
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
