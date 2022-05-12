import java.util.*;

public class memory
{
    public static ArrayList<profile> index = new ArrayList<profile>();
    public static Map<String, String> credentials = new TreeMap<String, String>();
    public static int x = 23;

    public static profile find(String b)
    {
        for (profile a : index) {
            if (a.getUsername().equals(b))
                return a;
        }
        return new profile("error", "error", "error");
    }

    public static void enact()
    {
        profile a3526726 = new profile("seth emerson", "seth", "1871");
        mem_3526726.enact(a3526726);
        profile a109761491 = new profile("steve", "steve", "chocolate");
        mem_109761491.enact(a109761491);
        a3526726.addToFollowing(a109761491);
        a109761491.addToFollowing(a3526726);
    }
}
