class post
{
    public static String username;
    public static String text;

    post(String username, String text)
    {
        this.username = username;
        this.text = text;

        add();
    }

    void add()
    {
        memoryA.posts.put(username,this);
    }
}