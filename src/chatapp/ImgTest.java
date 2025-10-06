import javax.swing.*;

public class ImgTest {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JLabel l = new JLabel(new ImageIcon(ImgTest.class.getResource("/icon/Chat.png")));
        f.add(l);
        f.setSize(200,200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
