import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class write
{
    public static void alt(String name, String username, String password) throws IOException
    {
        ArrayList<String> content = new ArrayList<String>();

        File temp = new File("C:\\Users\\emersset000\\IdeaProjects\\usma\\src\\mem_temp.java");
        BufferedReader br = new BufferedReader(new FileReader(temp));
        String line = br.readLine();

        while (line != null) {
            content.add(line + "\n");
            line = br.readLine();
        }
        br.close();

        content.set(2, "public class mem_" + username.hashCode());
        content.add(8, "        profile a" + username.hashCode() + " = new profile(\"" + name + "\", \"" + username + "\", \"" + password + "\");\n");

        File file = new File("C:\\Users\\emersset000\\IdeaProjects\\usma\\src\\mem_" + username.hashCode() + ".java");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);

        for (int a = 0; a < content.size(); a++)
            fw.write(content.get(a));
        fw.close();
    }

    public static void createPost(profile a, String text) throws IOException
    {
        ArrayList<String> content = new ArrayList<String>();

        File file = new File("C:\\Users\\emersset000\\IdeaProjects\\usma\\src\\mem_" + a.username.hashCode() + ".java");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();

        while (line != null) {
            content.add(line + "\n");
            line = br.readLine();
        }
        br.close();
        
        content.add(8, "        post b " + a.posts.size() + "= new post(\"" + text + "\");\n");

        FileWriter fw = new FileWriter(file);

        for (int b = 0; b < content.size(); b++)
            fw.write(content.get(b));
        fw.close();
    }
}
