class post
{
    private String text;

    post(profile a, String text)
    {
        this.text = text;

        a.addToPosts(this);
        a.addToX();
    }

    String getText() { return text; }
}