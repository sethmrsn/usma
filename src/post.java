class post
{
    public static String text;

    post(profile a, String text)
    {
        this.text = text;
        a.posts.add(text);
    }
}