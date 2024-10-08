package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CookiePanel extends JPanel implements MouseListener, Runnable {
    private final int WIDTH = 650; private final int HEIGHT = 700;
    Dimension SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private ImageIcon cookie = ImageLoader.loadImage("/game/images/cookie.png");
    private ImageIcon upgrades = ImageLoader.loadImage("/game/images/upgrades.png");
    private ImageIcon grandma = ImageLoader.loadImage("/game/images/grandma.png");
    private ImageIcon bakery = ImageLoader.loadImage("/game/images/bakery.png");
    private ImageIcon click = ImageLoader.loadImage("/game/images/click.png");
    private ImageIcon factory = ImageLoader.loadImage("/game/images/factory.png");
    private ImageIcon business = ImageLoader.loadImage("/game/images/business.png");
    private ImageIcon world = ImageLoader.loadImage("/game/images/world.png");
    private ImageIcon space = ImageLoader.loadImage("/game/images/space.png");
    private ImageIcon universe = ImageLoader.loadImage("/game/images/universe.png");
    private ImageIcon exit = ImageLoader.loadImage("/game/images/exit.png");
    private JLabel bigCookie, money, upgrade, grandmas, grandmaStat, grandmaUpgrade, bakeryPic, bakeryStat, bakeryUpgrade, clickPic, clickStat,
            clickUpgrade, factoryPic, factoryUpgrade, factoryStat, businessPic, businessStat, businessUpgrade, worldPic, worldStat, worldUpgrade, congrats, spacePic,
            spaceStat, spaceUpgrade, universePic, universeStat, universeUpgrade, exitPic;
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    private int cash = 0;
    private int clickValue = 1; private int clickCost = 100; private int clickMax = 0;
    private int grandmaCost = 10; private int grandmaAdd = 0;
    private int bakeryCost = 50; private int bakeryAdd = 0;
    private int factoryCost = 1000; private int factoryAdd = 0;
    private int businessCost = 10000; private int businessAdd = 0;
    private int worldCost = 30000; private int worldAdd = 0;
    private int spaceCost = 75000; private int spaceAdd = 0;
    private int universeCost = 125000; private int universeAdd = 0;
    public int total = 0;
    public int upgradeTotal = 0;
    public int spent = 0;
    Thread gameThread;
    private Timer grandmaTimer, bakeryTimer, factoryTimer, businessTimer, worldTimer, spaceTimer, universeTimer;

    public CookiePanel() {
        setPreferredSize(SIZE);
        setLayout(null);
        setBackground(new Color(70, 130, 180));

        //JLabel declaration
        bigCookie = new JLabel("");
        upgrade = new JLabel("");
        grandmas = new JLabel("");
        bakeryPic = new JLabel("");
        clickPic = new JLabel("");
        factoryPic = new JLabel("");
        businessPic = new JLabel("");
        worldPic = new JLabel("");
        spacePic = new JLabel("");
        universePic = new JLabel("");
        exitPic = new JLabel("");

        congrats = new JLabel("Congratulations You Won!");
        money = new JLabel("$" + String.valueOf(cash));
        grandmaStat = new JLabel("$" + String.valueOf(grandmaAdd) + "/3 sec.");
        grandmaUpgrade = new JLabel("Upgrade: $" + String.valueOf(grandmaCost));
        bakeryStat = new JLabel("$" + String.valueOf(bakeryAdd) + "/5 sec.");
        bakeryUpgrade = new JLabel("Upgrade: $" + String.valueOf(bakeryCost));
        clickStat = new JLabel("$" + String.valueOf(clickValue) + "/click");
        clickUpgrade = new JLabel("Upgrade: $" + String.valueOf(clickCost));
        factoryStat = new JLabel("$" + String.valueOf(factoryAdd) + "/10 sec.");
        factoryUpgrade = new JLabel("Upgrade: $" + String.valueOf(factoryCost));
        businessStat = new JLabel("$" + String.valueOf(businessAdd + "/12 sec."));
        businessUpgrade = new JLabel("Upgrade: $" + String.valueOf(businessCost));
        worldStat = new JLabel("$" + String.valueOf(worldAdd) + "/15 sec.");
        worldUpgrade = new JLabel("Upgrade: $" + String.valueOf(worldCost));
        spaceStat = new JLabel("$" + String.valueOf(spaceAdd) + "/18 sec.");
        spaceUpgrade = new JLabel("Upgrade: $" + String.valueOf(spaceCost));
        universeStat = new JLabel("$" + String.valueOf(universeAdd) + "/20 sec.");
        universeUpgrade = new JLabel("Upgrade: $" + String.valueOf(universeCost));

        //JLabel setting positions
        setStuff(bigCookie, WIDTH/2 - 130, HEIGHT/2 - 130, 260, 260, 0);
        setStuff(money, 10, 11, 630, 67, 45);
        setStuff(upgrade, 950, 10, 128, 128, 0);
        setStuff(congrats, 10, HEIGHT - 45, 630, 67, 45);
        congrats.setVisible(false);
        setStuff(exitPic, 1220, 480, 80, 80, 0);

        setStuff(clickPic, 730, 190, 64, 64, 0);
        setStuff(grandmas, 730, 280, 64, 64, 0);
        setStuff(bakeryPic, 730, 370, 64, 64, 0);
        setStuff(factoryPic, 730, 460, 64, 64, 0);
        setStuff(businessPic, 730, 550, 64, 64, 0);
        setStuff(worldPic, 1075, 190, 64, 64, 0);
        setStuff(spacePic, 1075, 280, 64, 64, 0);
        setStuff(universePic, 1075, 370, 64, 64, 0);

        setStuff(clickStat, 810, 190, 146, 32, 15);
        setStuff(grandmaStat, 810, 280, 146, 32, 15);
        setStuff(bakeryStat, 810, 370, 146, 32, 15);
        setStuff(factoryStat, 810, 460, 146, 32, 15);
        setStuff(businessStat, 810, 550, 146, 32, 15);
        setStuff(worldStat, 1155, 190, 146, 32, 15);
        setStuff(spaceStat, 1155, 280, 146, 32, 15);
        setStuff(universeStat, 1155, 370, 146, 32, 15);

        setStuff(clickUpgrade, 810, 220, 146, 40, 15);
        setStuff(grandmaUpgrade, 810, 310, 146, 40, 15);
        setStuff(bakeryUpgrade, 810, 400, 146, 40, 15);
        setStuff(factoryUpgrade, 810, 490, 146, 40, 15);
        setStuff(businessUpgrade, 810, 580, 146, 40, 15);
        setStuff(worldUpgrade, 1155, 220, 146, 40, 15);
        setStuff(spaceUpgrade, 1155, 310, 146, 40, 15);
        setStuff(universeUpgrade, 1155, 400, 146, 40, 15);

        //JLabel icons and mouse listener
        upgrade.setIcon(upgrades);
        bigCookie.setIcon(cookie);
        clickPic.setIcon(click);
        grandmas.setIcon(grandma);
        bakeryPic.setIcon(bakery);
        factoryPic.setIcon(factory);
        businessPic.setIcon(business);
        worldPic.setIcon(world);
        spacePic.setIcon(space);
        universePic.setIcon(universe);
        exitPic.setIcon(exit);

        upgrade.addMouseListener(this);
        bigCookie.addMouseListener(this);
        grandmaUpgrade.addMouseListener(this);
        bakeryUpgrade.addMouseListener(this);
        clickUpgrade.addMouseListener(this);
        factoryUpgrade.addMouseListener(this);
        businessUpgrade.addMouseListener(this);
        worldUpgrade.addMouseListener(this);
        spaceUpgrade.addMouseListener(this);
        universeUpgrade.addMouseListener(this);
        exitPic.addMouseListener(this);

        //Timers
        grandmaTimer = new Timer(3000, null);
        grandmaTimer.addActionListener(new GrandmaListener());

        bakeryTimer = new Timer(5000, null);
        bakeryTimer.addActionListener(new BakeryListener());

        factoryTimer = new Timer(10000, null);
        factoryTimer.addActionListener(new FactoryListener());

        businessTimer = new Timer(12000, null);
        businessTimer.addActionListener(new BusinessListener());

        worldTimer = new Timer(15000, null);
        worldTimer.addActionListener(new WorldListener());

        spaceTimer= new Timer(18000, null);
        spaceTimer.addActionListener(new SpaceListener());

        universeTimer= new Timer(20000, null);
        universeTimer.addActionListener(new UniverseListener());

        //Thread
        gameThread = new Thread(this);
        gameThread.start();

    }

    private void setStuff(JLabel label, int x, int y, int z, int g, int font) {
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, font));
        label.setBounds(x, y, z, g);
        this.add(label);
    }

    private void setUpgrades(int cost, int add, JLabel stat, JLabel upgrade, int sec, int costInc)
    {
        stat.setText("$" + String.valueOf(add) + "/" + sec + "sec.");
        upgrade.setText("Upgrade: $" + String.valueOf(cost + costInc));
        if(add >= 40000 || cost >= 40000)
        {
            stat.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
            upgrade.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
        }
        cash = cash - cost;
        upgradeTotal++;
        spent += cost;
    }

    public int getCash()
    {
        return total;
    }
    public int getUpgrade()
    {
        return upgradeTotal;
    }
    public int getSpent()
    {
        return spent;
    }

    @Override
    public void run()
    {
        while(true)
        {
            grandmaTimer.start();
            bakeryTimer.start();
            factoryTimer.start();
            businessTimer.start();
            worldTimer.start();
            spaceTimer.start();
            universeTimer.start();
            if(cash == 2147483647)
            {
                grandmaAdd = 0;
                bakeryAdd = 0;
                factoryAdd = 0;
                businessAdd = 0;
                worldAdd = 0;
                universeAdd = 0;
                grandmaUpgrade.removeMouseListener(this);
                bakeryUpgrade.removeMouseListener(this);
                clickUpgrade.removeMouseListener(this);
                factoryUpgrade.removeMouseListener(this);
                businessUpgrade.removeMouseListener(this);
                worldUpgrade.removeMouseListener(this);
                spaceUpgrade.removeMouseListener(this);
                universeUpgrade.removeMouseListener(this);
                congrats.setVisible(true);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e) {
        Object src = e.getSource();
        if(src == grandmaUpgrade)
        {
            grandmaUpgrade.setBorder(border);
        }
        if(src == bakeryUpgrade)
        {
            bakeryUpgrade.setBorder(border);
        }
        if(src == clickUpgrade)
        {
            clickUpgrade.setBorder(border);
        }
        if(src == factoryUpgrade)
        {
            factoryUpgrade.setBorder(border);
        }
        if(src == businessUpgrade)
        {
            businessUpgrade.setBorder(border);
        }
        if(src == worldUpgrade)
        {
            worldUpgrade.setBorder(border);
        }
        if(src == spaceUpgrade)
        {
            spaceUpgrade.setBorder(border);
        }
        if(src == universeUpgrade)
        {
            universeUpgrade.setBorder(border);
        }
        if(src == exitPic)
        {
            exitPic.setBorder(border);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        if(src == grandmaUpgrade)
        {
            grandmaUpgrade.setBorder(null);
        }
        if(src == bakeryUpgrade)
        {
            bakeryUpgrade.setBorder(null);
        }
        if(src == clickUpgrade)
        {
            clickUpgrade.setBorder(null);
        }
        if(src == factoryUpgrade)
        {
            factoryUpgrade.setBorder(null);
        }
        if(src == businessUpgrade)
        {
            businessUpgrade.setBorder(null);
        }
        if(src == worldUpgrade)
        {
            worldUpgrade.setBorder(null);
        }
        if(src == spaceUpgrade)
        {
            spaceUpgrade.setBorder(null);
        }
        if(src == universeUpgrade)
        {
            universeUpgrade.setBorder(null);
        }
        if(src == exitPic)
        {
            exitPic.setBorder(null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object src = e.getSource();
        if(src == bigCookie) //click on big cookie for money
        {
            cash += clickValue;
            money.setText(String.valueOf("$" + cash));
            total += clickValue;
        }
        if(src == clickUpgrade) //click upgrades
        {
            if(cash >= clickCost && clickMax <= 50)
            {
                cash = cash - clickCost;
                spent += clickCost;
                clickValue++;
                clickCost += clickCost/2;
                clickStat.setText("$" + String.valueOf(clickValue) + "/click");
                clickUpgrade.setText("Upgrade: $" + String.valueOf(clickCost));
                clickMax++;
            }
            if(clickMax >= 50) //click max
            {
                clickUpgrade.removeMouseListener(this);
                clickUpgrade.setText("Maxed!");
                clickUpgrade.setBorder(null);
            }
        }
        if(src == grandmaUpgrade) //grandma upgrades
        {
            if(cash >= grandmaCost)
            {
                grandmaAdd += 3;
                grandmaCost += 10;
                setUpgrades(grandmaCost - 10, grandmaAdd, grandmaStat, grandmaUpgrade, 3, 10);
            }
        }
        if(src == bakeryUpgrade) //bakery upgrades
        {
            if(cash >= bakeryCost)
            {
                bakeryAdd += 15;
                bakeryCost += 35;
                setUpgrades(bakeryCost - 35, bakeryAdd, bakeryStat, bakeryUpgrade, 5, 35);
            }
        }
        if(src == factoryUpgrade) //factory upgrades
        {
            if(cash >= factoryCost)
            {
                factoryAdd += 150;
                factoryCost += 1250;
                setUpgrades(factoryCost - 1250, factoryAdd, factoryStat, factoryUpgrade, 10, 1250);
            }
        }
        if(src == businessUpgrade) //business upgrades
        {
            if(cash >= businessCost)
            {
                businessAdd += 750;
                businessCost += 10000;
                setUpgrades(businessCost - 10000, businessAdd, businessStat, businessUpgrade, 12, 10000);
            }
        }
        if(src == worldUpgrade) //world upgrades
        {
            if(cash >= worldCost)
            {
                worldAdd += 2000;
                worldCost += 10000;
                setUpgrades(worldCost - 10000, worldAdd, worldStat, worldUpgrade, 15, 10000);
            }
        }
        if(src == spaceUpgrade) //space upgrades
        {
            if(cash >= spaceCost)
            {
                spaceAdd += 7000;
                spaceCost += 50000;
                setUpgrades(spaceCost - 50000, spaceAdd, spaceStat, spaceUpgrade, 18, 50000);
            }
        }
        if(src == universeUpgrade) //space upgrades
        {
            if(cash >= universeCost)
            {
                universeAdd += 15000;
                universeCost += 150000;
                setUpgrades(universeCost - 150000, universeAdd, universeStat, universeUpgrade, 20, 150000);
            }
        }
        if(src == exitPic) {System.exit(0);}
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    public class GrandmaListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            grandmaTimer.stop();
            cash += grandmaAdd;
            money.setText(String.valueOf("$" + cash));
            total += grandmaAdd;
        }
    }
    public class BakeryListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            bakeryTimer.stop();
            cash += bakeryAdd;
            money.setText(String.valueOf("$" + cash));
            total += bakeryAdd;
        }
    }
    public class FactoryListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            factoryTimer.stop();
            cash += factoryAdd;
            money.setText(String.valueOf("$" + cash));
            total += factoryAdd;
        }
    }
    public class BusinessListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            businessTimer.stop();
            cash += businessAdd;
            money.setText(String.valueOf("$" + cash));
            total += businessAdd;
        }
    }
    public class WorldListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            worldTimer.stop();
            cash += worldAdd;
            money.setText(String.valueOf("$" + cash));
            total += worldAdd;
        }
    }
    public class SpaceListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            spaceTimer.stop();
            cash += spaceAdd;
            money.setText(String.valueOf("$" + cash));
            total += spaceAdd;
        }
    }
    public class UniverseListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            universeTimer.stop();
            cash += universeAdd;
            money.setText(String.valueOf("$" + cash));
            total += universeAdd;
        }
    }
}
