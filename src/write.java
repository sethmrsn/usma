import java.io.*;
import java.util.ArrayList;

public class write
{
    public static void alt(String name, String username, String password) throws IOException
    {
        ArrayList<String> content = new ArrayList<String>();

        File main = new File("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\src\\memory.java");
        //File main = new File("/Users/seth/IdeaProjects/usma/src/memory.java");
        BufferedReader br = new BufferedReader(new FileReader(main));
        String line = br.readLine();

        while (line != null) {
            content.add(line + "\n");
            line = br.readLine();
        }
        br.close();

        content.add(19 + memory.index.size() * 2, "        profile a" + username.hashCode() + " = new profile(\"" + name + "\", \"" + username + "\", \"" + password + "\");\n");
        content.add(20 + memory.index.size() * 2, "        mem_" + username.hashCode() + ".enact(a" + username.hashCode() + ");\n");
        content.set(6, "    public static int x = " + memory.x++ + ";\n");

        FileWriter fw = new FileWriter(main);

        for (int a = 0; a < content.size(); a++)
            fw.write(content.get(a));
        fw.close();

        content.clear();

        File temp = new File("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\src\\mem_temp.java");
        //File temp = new File("/Users/seth/IdeaProjects/usma/src/mem_temp.java");
        BufferedReader br2 = new BufferedReader(new FileReader(temp));
        line = br2.readLine();

        while (line != null) {
            content.add(line + "\n");
            line = br2.readLine();
        }
        br2.close();

        content.set(0, "public class mem_" + username.hashCode() + "\n");

        File file = new File("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\src\\mem_" + username.hashCode() + ".java");
        //File file = new File("/Users/seth/IdeaProjects/usma/src/mem_" + username.hashCode() + ".java");
        file.createNewFile();
        FileWriter fw2 = new FileWriter(file);

        for (int a = 0; a < content.size(); a++)
            fw2.write(content.get(a));
        fw2.close();
    }

    public static void createPost(profile a, String text) throws IOException
    {
        ArrayList<String> content = new ArrayList<String>();

        File file = new File("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\src\\mem_" + a.getUsername().hashCode() + ".java");
        //File file = new File("/Users/seth/IdeaProjects/usma/src/mem_" + a.getUsername().hashCode() + ".java");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();

        while (line != null) {
            content.add(line + "\n");
            line = br.readLine();
        }
        br.close();

        content.add(4 + a.getPosts().size(), "        post b" + a.getPosts().size() + " = new post(a, \"" + text + "\");\n");

        FileWriter fw = new FileWriter(file);

        for (int b = 0; b < content.size(); b++)
            fw.write(content.get(b));
        fw.close();
    }
}
