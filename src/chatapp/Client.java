package chatapp;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Client implements ActionListener {

    JTextField text;
    static JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;

    public Client() {
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setLayout(null);
        p1.setBounds(0, 0, 450, 90);
        f.add(p1);

        f.setSize(450, 700);
        f.setLocation(800, 90);
        f.getContentPane().setBackground(Color.WHITE);

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
        URL imageprofile = getClass().getResource("/icons/2.png");
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
        Image i14 = i13.getImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel more = new JLabel(i15);
        more.setBounds(400, 20, 50, 50);
        p1.add(more);

        JLabel name = new JLabel("Client Name");
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
        a1 = new JPanel();
        a1.setBounds(5, 95, 440, 540);
        f.add(a1);
        f.setVisible(true);

        text = new JTextField();
        text.setBounds(5, 640, 345, 50);
        text.setFont(new Font("SAN_SEDIF", Font.BOLD, 14));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(355, 640, 90, 50);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        f.add(send);

        // click event
        send.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {

            String out = text.getText();
            JPanel p2 = formatLabel(out);

            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);

            dout.writeUTF(out);

            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);
            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output = new JLabel("<html><p style =\"width:150px \">" + out + "</p></html>");
        output.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;

    }

    public static void main(String[] args) {

        new Client();
        try {
            Socket s = new Socket("127.0.0.1", 6001);

            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while (true) {
                a1.setLayout(new BorderLayout());
                String msg = din.readUTF();
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);

                vertical.add(Box.createVerticalStrut(15));
                a1.add(vertical,BorderLayout.PAGE_START);
                f.validate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}