import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.event.*;

class home implements ActionListener
{
    JFrame frame;
    JPanel row, feed, search, create, inbox, profile;
    profile a;

    home(profile a)
    {
        this.a = a;

        frame = new JFrame();
        row = new JPanel();
        search = new JPanel();
        create = new JPanel();
        profile = new JPanel();
        feed = new JPanel();
        inbox = new JPanel();

        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);

        row.setLayout(null);
        feed.setLayout(null);
        search.setLayout(null);
        create.setLayout(null);
        inbox.setLayout(null);
        profile.setLayout(null);

        row.setBounds(0, 400, 400, 100);
        feed.setBounds(0, 0, 400, 400);
        search.setBounds(0,0,400,400);
        create.setBounds(0, 0, 400, 400);
        inbox.setBounds(0, 0, 400, 400);
        profile.setBounds(0,0,400,400);

        row();
        feed();
        search();
        create();
        inbox();
        profile();

        frame.add(row);
        frame.add(feed);
        frame.add(search);
        frame.add(create);
        frame.add(inbox);
        frame.add(profile);

        row.setVisible(true);
        feed.setVisible(false);
        search.setVisible(false);
        create.setVisible(false);
        inbox.setVisible(false);
        profile.setVisible(true);
        frame.setVisible(true);
    }

    void row()
    {
        ImageIcon feedIcon, searchIcon, createIcon, inboxIcon, profileIcon;
        JButton feedButton, searchButton, createButton, inboxButton, profileButton;

        feedIcon = new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\icon-feed.png");
        searchIcon = new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\icon-search.png");
        createIcon = new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\icon-create.png");
        inboxIcon = new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\icon-inbox.png");
        profileIcon = new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\icon-profile.png");

        feedButton = new JButton(feedIcon);
        searchButton = new JButton(searchIcon);
        createButton = new JButton(createIcon);
        inboxButton = new JButton(inboxIcon);
        profileButton = new JButton(profileIcon);

        feedButton.setBounds(0, 0, 80, 80);
        searchButton.setBounds(80, 0, 80, 80);
        createButton.setBounds(160, 0, 80, 80);
        inboxButton.setBounds(240, 0, 80, 80);
        profileButton.setBounds(320, 0, 80, 80);

        /*feedButton.setBorderPainted(false);
        searchButton.setBorderPainted(false);
        createButton.setBorderPainted(false);
        inboxButton.setBorderPainted(false);
        profileButton.setBorderPainted(false);*/

        feedButton.addActionListener(e -> {
            search.setVisible(false);
            create.setVisible(false);
            inbox.setVisible(false);
            profile.setVisible(false);
            feed.setVisible(true);
        });
        searchButton.addActionListener(e -> {
            feed.setVisible(false);
            create.setVisible(false);
            inbox.setVisible(false);
            profile.setVisible(false);
            search.setVisible(true);
        });
        createButton.addActionListener(e -> {
            feed.setVisible(false);
            search.setVisible(false);
            create.setVisible(false);
            inbox.setVisible(false);
            profile.setVisible(false);
            create.setVisible(true);
        });
        inboxButton.addActionListener(e -> {
            feed.setVisible(false);
            search.setVisible(false);
            create.setVisible(false);
            inbox.setVisible(false);
            profile.setVisible(false);
            inbox.setVisible(true);
        });
        profileButton.addActionListener(e -> {
            feed.setVisible(false);
            search.setVisible(false);
            create.setVisible(false);
            inbox.setVisible(false);
            profile.setVisible(true);
        });

        row.add(feedButton);
        row.add(searchButton);
        row.add(createButton);
        row.add(inboxButton);
        row.add(profileButton);
    }

    void feed()
    {
        DefaultListModel listModel;
        JList list;
        JScrollPane posts;

        listModel = new DefaultListModel();
        list = new JList(listModel);

        list.setEnabled(false);
        list.setLayoutOrientation(0);
        list.setVisibleRowCount(-1);

        posts = new JScrollPane(list);

        posts.setBounds(25, 25, 350, 350);

        posts.isWheelScrollingEnabled();

        for(int b = a.getFollowing().size() - 1; b > -1; b--)
            for(int c = a.getFollowing().get(b).getPosts().size() - 1; c > - 1; c--)
                listModel.addElement(a.getFollowing().get(b).getUsername() + " >> " + a.getFollowing().get(b).getPosts().get(c).getText());

        feed.add(posts);
    }

    void search()
    {
        JTextField text;
        JButton find;

        DefaultListModel listModel;
        JList list;
        JScrollPane profiles;

        text = new JTextField(1);
        find = new JButton("search");

        listModel = new DefaultListModel();
        list = new JList(listModel);

        list.setEnabled(false);
        list.setLayoutOrientation(0);
        list.setVisibleRowCount(-1);

        profiles = new JScrollPane(list);

        text.setBounds(100,25,200,25);
        find.setBounds(150,55,100,33);
        profiles.setBounds(25, 100, 350, 275);

        find.addActionListener(e -> {
            listModel.clear();
            profile b = memory.find(text.getText());
            listModel.addElement(b.getName() + " // @" + b.getUsername());
        });

        search.add(text);
        search.add(find);
        search.add(profiles);
    }

    void create()
    {
        JLabel textLabel;
        JTextField text;
        JButton upload;

        textLabel = new JLabel("text:");
        text = new JTextField(2);
        upload = new JButton("upload");

        textLabel.setBounds(187,200,25,25);
        text.setBounds(100,225,200,50);
        upload.setBounds(150,280,100,33);

        upload.addActionListener(e -> {
            a.createPost(a, text.getText());
            create.setVisible(false);
            profile.setVisible(true);
        });

        create.add(textLabel);
        create.add(text);
        create.add(upload);
    }

    void inbox()
    {
        DefaultListModel listModel, listModel0;
        JList list, list0;
        JScrollPane pane, pane0;

        listModel = new DefaultListModel();
        listModel0 = new DefaultListModel();
        list = new JList(listModel);
        list0 = new JList(listModel0);

        list.setEnabled(false);
        list.setLayoutOrientation(0);
        list.setVisibleRowCount(-1);

        list0.setEnabled(false);
        list0.setLayoutOrientation(0);
        list0.setVisibleRowCount(-1);

        pane = new JScrollPane(list);
        pane0 = new JScrollPane(list0);

        pane.setBounds(25, 25, 350, 350);
        pane0.setBounds(25, 25, 350, 350);

        pane.isWheelScrollingEnabled();
        pane0.isWheelScrollingEnabled();

        inbox.add(pane);
    }

    void profile()
    {
        JLabel nameLabel, usernameLabel, followersLabel, followingLabel;
        JButton followers, following;
        DefaultListModel listModel;
        JList list;
        JScrollPane posts;

        nameLabel = new JLabel(a.getName(), 0);
        usernameLabel = new JLabel("@" + a.getUsername(), 0);
        followersLabel = new JLabel("followers");
        followingLabel = new JLabel("following");
        followers = new JButton(String.valueOf(a.getFollowers().size()));
        following = new JButton(String.valueOf(a.getFollowing().size()));
        listModel = new DefaultListModel();
        list = new JList(listModel);

        list.setEnabled(false);
        list.setLayoutOrientation(0);
        list.setVisibleRowCount(-1);

        posts = new JScrollPane(list);

        nameLabel.setBounds(125, 50, 150, 25);
        usernameLabel.setBounds(125, 75, 150, 25);
        followersLabel.setBounds(140, 115, 55, 25);
        followingLabel.setBounds(140, 140, 55, 25);
        followers.setBounds(200, 97, 60, 60);
        posts.setBounds(25, 200, 350, 175);

        followers.setContentAreaFilled(false);
        following.setContentAreaFilled(false);

        followers.setBorderPainted(false);
        following.setBorderPainted(false);

        posts.isWheelScrollingEnabled();

        for(int b = a.getPosts().size() - 1; b > -1; b--) {
            System.out.println(a.getPosts().get(b).getText());
            listModel.addElement(a.getUsername() + " >> " + a.getPosts().get(b).getText());
        }

        profile.add(nameLabel);
        profile.add(usernameLabel);
        profile.add(followersLabel);
        profile.add(followingLabel);
        profile.add(followers);
        profile.add(following);
        profile.add(posts);
    }

    public void actionPerformed(ActionEvent e) {}
}
