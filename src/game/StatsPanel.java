package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StatsPanel extends JPanel {
    private final int WIDTH = 800; private final int HEIGHT = 600;
    private Dimension SIZE = new Dimension(WIDTH, HEIGHT);
    CookiePanel panel = new CookiePanel();
    private JLabel title, upgradeTotal, moneyTotal, moneyPic, upgradePic, spendPic;
    private ImageIcon money = ImageLoader.loadImage("/game/images/money.png");
    private ImageIcon upgrade = ImageLoader.loadImage("/game/images/upgradeSmall.png");
    private ImageIcon spend = ImageLoader.loadImage("/game/images/spend.png");

    public StatsPanel() {
        setPreferredSize(SIZE);
        setLayout(null);
        setBackground(new Color(70, 130, 180));

        title = new JLabel("Statistics");
        setStuff(title, 230, 20, 310, 40, 40);

        //moneyTotal = new JLabel(String.valueOf(total));
        //setStuff(moneyTotal, 250, 140, 310, 40, 40);

        moneyPic = new JLabel("");
        moneyPic.setIcon(money);
        setStuff(moneyPic, 200, 130, 64, 64, 0);

        upgradePic = new JLabel("");
        upgradePic.setIcon(upgrade);
        setStuff(upgradePic, 200, 270, 64, 64, 0);

        spendPic = new JLabel("");
        spendPic.setIcon(spend);
        setStuff(spendPic, 200, 410, 64, 64, 0);
    }

    private void setStuff(JLabel label, int x, int y, int z, int g, int font) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe Script", Font.PLAIN, font));
        label.setBounds(x, y, z, g);
        this.add(label);
    }
}
