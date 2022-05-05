import java.io.IOException;
import java.util.*;

class profile
{
    public static String name, username, password;
    public static ArrayList<profile> followers, following;
    public static ArrayList<post> posts;

    profile(String a, String b, String c)
    {
        name = a;
        username = b;
        password = c;

        followers = new ArrayList<profile>();
        following = new ArrayList<profile>();

        posts = new ArrayList<post>();

        add();
    }

    void add()
    {
        memoryA.index.add(this);
        memoryA.credentials.put(username, password);
    }

    void createPost(profile a, String text)
    {
        try {
            write.createPost(a, text);
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
