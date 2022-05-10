import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

class home implements ActionListener
{
    JFrame frame;
    JPanel row, search, create, profile;
    JScrollPane feed, inbox;
    profile a;

    home(profile a)
    {
        this.a = a;

        frame = new JFrame();
        row = new JPanel();
        search = new JPanel();
        create = new JPanel();
        profile = new JPanel();
        feed = new JScrollPane();
        inbox = new JScrollPane();

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

        /*try {
            write.info(a);
        } catch (IOException e) {
            System.out.println("ERROR");
        }*/

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
    }

    void search()
    {
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
        upload.setBounds(150,340,100,33);

        upload.addActionListener(e -> {
            a.createPost(a, text.getText());
            refresh();
            create.setVisible(false);
            profile.setVisible(true);
        });

        create.add(textLabel);
        create.add(text);
        create.add(upload);
    }

    void inbox()
    {
    }

    void profile()
    {
        JLabel nameLabel, usernameLabel, followersLabel, followingLabel;
        JButton followers, following;
        DefaultListModel listModel;
        JList list;
        JScrollPane posts;

        nameLabel = new JLabel(a.name, 0);
        usernameLabel = new JLabel("@" + a.username, 0);
        followersLabel = new JLabel("followers");
        followingLabel = new JLabel("following");
        followers = new JButton(String.valueOf(a.followers.size()));
        following = new JButton(String.valueOf(a.following.size()));
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
        following.setBounds(200, 122, 60, 60);
        posts.setBounds(0, 200, 400, 220);

        followers.setContentAreaFilled(false);
        following.setContentAreaFilled(false);

        followers.setBorderPainted(false);
        following.setBorderPainted(false);

        //followers.addActionListener(e -> {System.out.println("this works");});
        //following.addActionListener(e -> {System.out.println("display new panel over profile")});

        posts.isWheelScrollingEnabled();


        for(int b = a.posts.size() - 1; b > -1; b--) {
            System.out.println(b);
            listModel.addElement(a.username + " >> " + a.posts.get(b));
        }
        profile.add(nameLabel);
        profile.add(usernameLabel);
        profile.add(followersLabel);
        profile.add(followingLabel);
        profile.add(followers);
        profile.add(following);
        profile.add(posts);

    }

    void refresh()
    {
        frame.remove(feed);
        frame.remove(search);
        frame.remove(create);
        frame.remove(inbox);
        frame.remove(profile);

        mem_3526726.enact(a);

        feed();
        search();
        create();
        inbox();
        profile();

        frame.add(feed);
        frame.add(search);
        frame.add(create);
        frame.add(inbox);
        frame.add(profile);
    }

    public void actionPerformed(ActionEvent e) {}
}
