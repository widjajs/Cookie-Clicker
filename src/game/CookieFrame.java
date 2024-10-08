package game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CookieFrame extends JFrame implements MouseListener, Runnable {

    private CookiePanel panel = new CookiePanel();
    private DirectionsPanel directions = new DirectionsPanel();
    private StatsPanel statistics = new StatsPanel();
    private JLabel questionPic, statsPic, back, back2, moneyTotal, upgradeTotal, spentTotal;
    private ImageIcon question = ImageLoader.loadImage("/game/images/question.png");
    private ImageIcon stats = ImageLoader.loadImage("/game/images/stats.png");
    private int total = 0;
    private int upgradeCount = 0;
    private int spent = 0;
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    Thread gameThread;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CookieFrame frame = new CookieFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CookieFrame() {
        ImageIcon icon = ImageLoader.loadImage("/game/images/bubble-tea.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.setResizable(true);
        this.setLocation(0, 0);
        panel = new CookiePanel();
        setContentPane(panel);
        pack();

        questionPic = new JLabel("");
        questionPic.setIcon(question);
        panel.add(questionPic);
        questionPic.addMouseListener(this);
        questionPic.setHorizontalAlignment(SwingConstants.CENTER);
        questionPic.setBounds(1125, 480, 80, 80);

        statsPic = new JLabel("");
        statsPic.setIcon(stats);
        panel.add(statsPic);
        statsPic.setHorizontalAlignment(SwingConstants.CENTER);
        statsPic.addMouseListener(this);
        statsPic.setBounds(1170, 570, 80, 80);

        back = new JLabel("BACK");
        directions.add(back);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.addMouseListener(this);
        back.setFont(new Font("Segoe Script", Font.PLAIN, 35));
        back.setBounds(330, 530, 150, 40);

        back2 = new JLabel("BACK");
        statistics.add(back2);
        back2.setHorizontalAlignment(SwingConstants.CENTER);
        back2.addMouseListener(this);
        back2.setFont(new Font("Segoe Script", Font.PLAIN, 35));
        back2.setBounds(330, 530, 150, 40);

        moneyTotal = new JLabel("$" + String.valueOf(total));
        statistics.add(moneyTotal);
        moneyTotal.setHorizontalAlignment(SwingConstants.CENTER);
        moneyTotal.addMouseListener(this);
        moneyTotal.setFont(new Font("Segoe Script", Font.PLAIN, 35));
        moneyTotal.setBounds(250, 140, 310, 40);

        upgradeTotal = new JLabel(String.valueOf(upgradeCount));
        statistics.add(upgradeTotal);
        upgradeTotal.setHorizontalAlignment(SwingConstants.CENTER);
        upgradeTotal.addMouseListener(this);
        upgradeTotal.setFont(new Font("Segoe Script", Font.PLAIN, 35));
        upgradeTotal.setBounds(250, 280, 310, 40);

        spentTotal = new JLabel("$" + String.valueOf(spent));
        statistics.add(spentTotal);
        spentTotal.setHorizontalAlignment(SwingConstants.CENTER);
        spentTotal.addMouseListener(this);
        spentTotal.setFont(new Font("Segoe Script", Font.PLAIN, 35));
        spentTotal.setBounds(250, 420, 310, 40);


        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        while(true)
        {
            total = panel.getCash();
            upgradeCount = panel.getUpgrade();
            spent = panel.getSpent();
            moneyTotal.setText("$" + String.valueOf(total));
            upgradeTotal.setText(String.valueOf(upgradeCount));
            spentTotal.setText(String.valueOf("$" + String.valueOf(spent)));
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object src = e.getSource();
        if(src == questionPic){questionPic.setBorder(border);}
        if(src == statsPic){statsPic.setBorder(border);}
        if(src == back){back.setBorder(border);}
        if(src == back2){back2.setBorder(border);}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object src = e.getSource();
        if(src == questionPic){questionPic.setBorder(null);}
        if(src == statsPic){statsPic.setBorder(null);}
        if(src == back){back.setBorder(null);}
        if(src == back2){back2.setBorder(null);}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object src = e.getSource();
        if(src == questionPic)
        {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocation(280, 50);
            this.setResizable(false);
            this.getContentPane().setLayout(null);
            this.setContentPane(directions);
            pack();
        }
        if(src == statsPic)
        {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocation(280, 50);
            this.setResizable(false);
            this.getContentPane().setLayout(null);
            this.setContentPane(statistics);
            pack();
        }
        if(src == back)
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            this.setResizable(true);
            this.setLocation(0, 0);
            setContentPane(panel);
            pack();
            back.setBorder(null);
            questionPic.setBorder(null);
            statsPic.setBorder(null);
        }
        if(src == back2)
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            this.setResizable(true);
            this.setLocation(0, 0);
            setContentPane(panel);
            pack();
            back2.setBorder(null);
            questionPic.setBorder(null);
            statsPic.setBorder(null);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
