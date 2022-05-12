import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class portal implements ActionListener
{
    JFrame frame;
    JPanel panel, panel0;
    JTextField uText, nText0, uText0, pText0;
    JPasswordField pText;
    JButton login, create, back0, finish0;

    portal()
    {
        frame = new JFrame();
        panel = new JPanel();
        panel0 = new JPanel();

        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);

        panel.setLayout(null);
        panel0.setLayout(null);

        panel();
        panel0();

        frame.add(panel);
        frame.setVisible(true);
    }

    void panel()
    {
        JLabel logo, uLabel, pLabel;

        logo = new JLabel(new ImageIcon("C:\\Users\\emersset000\\Documents\\GitHub\\usma\\images\\logo-main.png"));
        uLabel = new JLabel("username:");
        pLabel = new JLabel("password:");
        uText = new JTextField();
        pText = new JPasswordField();
        login = new JButton("log in");
        create = new JButton("create account");

        logo.setBounds(100, 50, 200, 200);
        uLabel.setBounds(90,270,70,25);
        pLabel.setBounds(90,300,70,25);
        uText.setBounds(160,270,150,25);
        pText.setBounds(160,300,150,25);
        login.setBounds(150,340,100,33);
        create.setBounds(140,380,120,33);

        create.setContentAreaFilled(false);

        create.setBorderPainted(false);

        login.addActionListener(this);
        create.addActionListener(this);

        panel.add(logo);
        panel.add(uLabel);
        panel.add(pLabel);
        panel.add(uText);
        panel.add(pText);
        panel.add(login);
        panel.add(create);
    }

    void panel0()
    {
        JLabel nLabel, uLabel, pLabel;

        nLabel = new JLabel("name:");
        uLabel = new JLabel("username:");
        pLabel = new JLabel("password:");
        nText0 = new JTextField();
        uText0 = new JTextField();
        pText0 = new JTextField();
        back0 = new JButton("back");
        finish0 = new JButton("finish");

        nLabel.setBounds(90,240,70,25);
        uLabel.setBounds(90,270,70,25);
        pLabel.setBounds(90,300,70,25);
        nText0.setBounds(160,240,150,25);
        uText0.setBounds(160,270,150,25);
        pText0.setBounds(160,300,150,25);
        back0.setBounds(140,380,120,33);
        finish0.setBounds(150,340,100,33);

        back0.setContentAreaFilled(false);

        back0.setBorderPainted(false);

        back0.addActionListener(this);
        finish0.addActionListener(this);

        panel0.add(nLabel);
        panel0.add(uLabel);
        panel0.add(pLabel);
        panel0.add(nText0);
        panel0.add(uText0);
        panel0.add(pText0);
        panel0.add(back0);
        panel0.add(finish0);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login) {
            String username = uText.getText();
            String password = String.valueOf(pText.getPassword());

            memory.credentials.put("admin", "1871");

            if (memory.credentials.containsKey(username) && memory.credentials.get(username).equals(password)) {
                frame.dispose();
                home a = new home(memory.find(username));
            } else
                JOptionPane.showMessageDialog(frame, "invalid credentials", "error", 0);
        }
        if (e.getSource() == create) {
            frame.add(panel0);
            panel.setVisible(false);
            panel0.setVisible(true);
        }
        if (e.getSource() == back0) {
            panel0.setVisible(false);
            panel.setVisible(true);
        }
        if (e.getSource() == finish0) {
            String name = nText0.getText();
            String username = uText0.getText();
            String password = pText0.getText();

            if (name.equals(""))
                JOptionPane.showMessageDialog(frame, "missing name", "error", 0);
            else if (username.length() < 2)
                JOptionPane.showMessageDialog(frame, "username must be at least 2 characters", "error", 0);
            else if (memory.credentials.containsKey(username))
                JOptionPane.showMessageDialog(frame, "username is not available", "error", 0);
            else if (password.length() < 8)
                JOptionPane.showMessageDialog(frame, "password must be at least 8 characters", "error", 0);
            else {
                try{
                    write.alt(name, username, password);
                    frame.dispose();
                    JOptionPane.showMessageDialog(frame, "account creation successful", "", 1);
                    //open.main(null, memoryA.find(username));
                }
                catch(IOException ex) {
                    JOptionPane.showMessageDialog(frame, "try again later", "error", 0);
                }
            }
        }
    }
}
