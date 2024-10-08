package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class DirectionsPanel extends JPanel implements MouseListener {
    private final int WIDTH = 800; private final int HEIGHT = 600;
    private Dimension SIZE = new Dimension(WIDTH, HEIGHT);
    private JLabel title, cookiePic, upgradePic, moneyPic;
    private ImageIcon upgrade = ImageLoader.loadImage("/game/images/upgradeSmall.png");
    private ImageIcon cookie = ImageLoader.loadImage("/game/images/cookieSmall.png");
    private ImageIcon money = ImageLoader.loadImage("/game/images/money.png");
    public DirectionsPanel() {
        setPreferredSize(SIZE);
        setLayout(null);
        setBackground(new Color(70, 130, 180));

        title = new JLabel("Directions");
        setStuff(title, 230, 20, 310, 40, 40);

        cookiePic = new JLabel("");
        cookiePic.setIcon(cookie);
        setStuff(cookiePic, 120, 130, 64, 64, 0);

        upgradePic = new JLabel("");
        upgradePic.setIcon(upgrade);
        setStuff(upgradePic, 120, 270, 64, 64, 0);

        moneyPic = new JLabel("");
        moneyPic.setIcon(money);
        setStuff(moneyPic, 120, 410, 64, 64, 0);

        JTextArea intro = new JTextArea();
        intro.setText("This is Cookie Clicker. Your goal is to make" + "\n" + "money by upgrading and clicking the cookie.");
        setArea(intro, 210, 130, 458, 64);

        JTextArea upgrade = new JTextArea();
        upgrade.setText("The pictures on the right make money automati" + "\n" + "-cally. They can be upgraded to earn more.");
        setArea(upgrade, 210, 270, 458, 64);

        JTextArea cash = new JTextArea();
        cash.setText("The number at the top is your money. Use this" + "\n" + "to buy upgrades");
        setArea(cash, 210, 410, 458, 64);
    }

    private void setStuff(JLabel label, int x, int y, int z, int g, int font) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe Script", Font.PLAIN, 40));
        label.setBounds(x, y, z, g);
        this.add(label);
    }

    private void setArea(JTextArea text, int x, int y, int z, int g) {
        text.setBackground(new Color(70, 130, 180));
        text.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 20));
        text.setBounds(x, y, z, g);
        this.add(text);
    }



    @Override
    public void mouseClicked(MouseEvent arg0) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
}
