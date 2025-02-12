import java.util.ArrayList;
import java.util.List;
public class SocialMediaManagement {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        socialMedia.addUser ("1", "Alice", 25);
        socialMedia.addUser ("2", "Bob", 30);
        socialMedia.addUser ("3", "Charlie", 22);
        socialMedia.addUser ("4", "David", 28);
		socialMedia.addFriend("1", "2");
        socialMedia.addFriend("1", "3");
        socialMedia.addFriend("2", "3");
        socialMedia.addFriend("3", "4");

        System.out.println("Displaying friends of Alice:");
        socialMedia.displayFriends("1");

        System.out.println("Displaying friends of Bob:");
        socialMedia.displayFriends("2");

        System.out.println("Displaying friends of Charlie:");
        socialMedia.displayFriends("3");

        System.out.println("Displaying friends of David:");
        socialMedia.displayFriends("4");

        System.out.println("Mutual friends between Alice and Bob:");
        List<String> mutualFriends = socialMedia.findMutualFriends("1", "2");
        System.out.println(mutualFriends);

        System.out.println("Removing friend connection between Alice and Bob.");
        socialMedia.removeFriend("1", "2");

        System.out.println("Displaying friends of Alice after removal:");
        socialMedia.displayFriends("1");

        System.out.println("Displaying friends of Bob after removal:");
        socialMedia.displayFriends("2");

        System.out.println("Count of friends for Charlie: " + socialMedia.countFriends("3"));
        System.out.println("Count of friends for David: " + socialMedia.countFriends("4"));
    }
}
class FriendNode {
    String friendId;
    FriendNode next;

    public FriendNode(String friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class User {
    String userId;
    String name;
    int age;
    FriendNode friendsHead;
    User next;

    public User(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser (String userId, String name, int age) {
        User newUser  = new User(userId, name, age);
        newUser .next = head;
        head = newUser ;
    }

    public void addFriend(String userId1, String userId2) {
        User user1 = searchUser (userId1);
        User user2 = searchUser (userId2);
        if (user1 != null && user2 != null && !isFriend(user1, userId2)) {
            addFriendToList(user1, userId2);
            addFriendToList(user2, userId1);
        }
    }

    private void addFriendToList(User user, String friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendsHead;
        user.friendsHead = newFriend;
    }

    public void removeFriend(String userId1, String userId2) {
        User user1 = searchUser (userId1);
        User user2 = searchUser (userId2);
        if (user1 != null && user2 != null) {
            removeFriendFromList(user1, userId2);
            removeFriendFromList(user2, userId1);
        }
    }

    private void removeFriendFromList(User user, String friendId) {
        FriendNode current = user.friendsHead;
        FriendNode previous = null;
        while (current != null) {
            if (current.friendId.equals(friendId)) {
                if (previous == null) {
                    user.friendsHead = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public List<String> findMutualFriends(String userId1, String userId2) {
        User user1 = searchUser (userId1);
        User user2 = searchUser (userId2);
        List<String> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            FriendNode friend1 = user1.friendsHead;
            while (friend1 != null) {
                if (isFriend(user2, friend1.friendId)) {
                    mutualFriends.add(friend1.friendId);
                }
                friend1 = friend1.next;
            }
        }
        return mutualFriends;
    }

    private boolean isFriend(User user, String friendId) {
        FriendNode current = user.friendsHead;
        while (current != null) {
            if (current.friendId.equals(friendId)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayFriends(String userId) {
        User user = searchUser (userId);
        if (user != null) {
            FriendNode current = user.friendsHead;
            System.out.print("Friends of " + user.name + ": ");
            while (current != null) {
                System.out.print(current.friendId + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public User searchUser (String searchTerm) {
        User current = head;
        while (current != null) {
            if (current.userId.equals(searchTerm) || current.name.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int countFriends(String userId) {
        User user = searchUser (userId);
        int count = 0;
        if (user != null) {
            FriendNode current = user.friendsHead;
            while (current != null) {
                count++;
                current = current.next;
            }
        }
        return count;
    }
}
