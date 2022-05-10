import java.util.*;

public class memoryA
{
    public static ArrayList<profile> index = new ArrayList<profile>();
    public static Map<String, String> credentials = new TreeMap<String, String>();
    public static int x = 120;

    public static profile find(String b)
    {
        for (profile a : index)
            if (profile.username.equals(b))
                return a;
        return new profile("error", "error", "error");
    }

    public static void enact()
    {
        profile a3526726 = new profile("seth emerson", "seth", "1871");
        mem_3526726.enact(a3526726);
    }
}
