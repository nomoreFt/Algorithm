import java.time.LocalDateTime;
import java.util.*;

class Twitter {
    class Tweet {
        int id;
        LocalDateTime createdTime;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.createdTime = LocalDateTime.now();
        }
    }

    class User {
        int id;
        Set<Integer> followers;
        Set<Integer> followees;
        Tweet tweetHead;

        User(int id) {
            this.id = id;
            followers = new HashSet<>();
            followees = new HashSet<>();
            tweetHead = null;
        }

        void postTweet(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        User user = userMap.get(userId);
        user.postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return result;
        }

        User user = userMap.get(userId);
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a, b) -> b.createdTime.compareTo(a.createdTime));

        addTweetsToFeed(feed, user.tweetHead);
        for (int followeeId : user.followees) {
            if (userMap.containsKey(followeeId)) {
                addTweetsToFeed(feed, userMap.get(followeeId).tweetHead);
            }
        }

        int count = 0;
        while (!feed.isEmpty() && count < 10) {
            result.add(feed.poll().id);
            count++;
        }

        return result;
    }

    private void addTweetsToFeed(PriorityQueue<Tweet> feed, Tweet head) {
        while (head != null) {
            feed.offer(head);
            head = head.next;
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.add(followeeId);
        followee.followers.add(followerId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId || !userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);

        follower.followees.remove(followeeId);
        followee.followers.remove(followerId);
    }
}
