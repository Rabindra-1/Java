package chatapp;

import java.awt.Color;
import java.net.URL;
import javax.swing.*;

public class Server extends JFrame {

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
        
        
        
        URL imageUrl = getClass().getResource("/icons/1.png");
        ImageIcon i1 = new ImageIcon(imageUrl);
        JLabel back = new JLabel(i1);
        back.setBounds(0, 0, 50, 50);
        p1.add(back);
        
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Server();
    }

}