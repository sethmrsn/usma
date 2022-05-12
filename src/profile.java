import java.io.IOException;
import java.util.*;

class profile
{
    private String name, username, password;
    private ArrayList<profile> followers, following;
    private ArrayList<post> posts;
    private int x;

    profile(String a, String b, String c)
    {
        name = a;
        username = b;
        password = c;

        followers = new ArrayList<profile>();
        following = new ArrayList<profile>();

        posts = new ArrayList<post>();

        memory.index.add(this);
        memory.credentials.put(username, password);
    }

    String getName()
    {
        return name;
    }

    String getUsername()
    {
        return username;
    }

    ArrayList<post> getPosts()
    {
        return posts;
    }

    ArrayList<profile> getFollowers()
    {
        return followers;
    }

    ArrayList<profile> getFollowing()
    {
        return following;
    }

    void addToX()
    {
        x++;
    }

    void addToPosts(post a)
    {
        posts.add(a);
    }

    void addToFollowers(profile a)
    {
        followers.add(a);
    }

    void addToFollowing(profile a)
    {
        following.add(a);
        a.addToFollowers(this);
    }

    void createPost(profile a, String text)
    {
        try {
            write.createPost(a, text);
        } catch (IOException e) {
            System.out.println("ERROR");
        }
        addToX();
    }
}
