package chatapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Server extends JFrame implements ActionListener {

    public Server() {
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setLayout(null);
        p1.setBounds(0, 0, 450, 90);
        add(p1);

        setSize(450, 700);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);

        // Back Button
        URL imageback = getClass().getResource("/icons/3.png");
        ImageIcon i1 = new ImageIcon(imageback);
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 50, 50);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        // profile
        URL imageprofile = getClass().getResource("/icons/1.png");
        ImageIcon i4 = new ImageIcon(imageprofile);
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(50, 20, 50, 50);
        p1.add(profile);

        // Video call
        URL videocall = getClass().getResource("/icons/video.png");
        ImageIcon i7 = new ImageIcon(videocall);
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 50, 50);
        p1.add(video);

        // Video call
        URL audiocall = getClass().getResource("/icons/video.png");
        ImageIcon i10 = new ImageIcon(audiocall);
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel audio = new JLabel(i12);
        audio.setBounds(360, 20, 50, 50);
        p1.add(audio);

        // Video call
        URL morebtn = getClass().getResource("/icons/3icon.png");
        ImageIcon i13 = new ImageIcon(morebtn);
        Image i14 = i13.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel more = new JLabel(i15);
        more.setBounds(400, 20, 50, 50);
        p1.add(more);

        JLabel name = new JLabel("Rabindra");
        name.setBounds(110, 25, 100, 18);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel active = new JLabel("Active Now");
        active.setBounds(110, 45, 100, 18);
        active.setForeground(Color.white);
        active.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p1.add(active);

        // pannel 2 (Base pannel)
        JPanel al = new JPanel();
        al.setBounds(5, 95, 440, 540);
        add(al);
        setVisible(true);



        JTextField text = new JTextField();
        text.setBounds(5,640,345,50);
        text.setFont(new Font("SAN_SEDIF",Font.BOLD,14));
        add(text);
        JButton send = new JButton("Send");
        send.setBounds(355,640,90,50);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF",Font.BOLD,16));
        add(send);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {

        new Server();
    }

}