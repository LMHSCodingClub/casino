import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericDeclaration;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.net.URL;
import javax.imageio.ImageIO;

public class SwingTest {
    public SwingTest() {
        startUpGame();
    }
    
    public static void startUpGame() {
        JFrame f = new JFrame("Roulette");
        f.setSize(900,450);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        f.setContentPane(mainP);

        mainP.setPreferredSize(new Dimension(800, 407));
        p0.setPreferredSize(new Dimension(800, 75));
        p1.setPreferredSize(new Dimension(800, 8));
        p2.setPreferredSize(new Dimension(800, 75));
        p3.setPreferredSize(new Dimension(800, 8));
        p4.setPreferredSize(new Dimension(800, 75));
        p5.setPreferredSize(new Dimension(800, 8));
        p6.setPreferredSize(new Dimension(800, 75));
        p7.setPreferredSize(new Dimension(800, 75));

        p0.setLayout(new GridLayout(1, 12));
        p1.setLayout(new GridLayout(1, 12));
        p2.setLayout(new GridLayout(1, 12));
        p3.setLayout(new GridLayout(1, 12));
        p4.setLayout(new GridLayout(1, 12));
        p5.setLayout(new GridLayout(1, 12));
        p6.setLayout(new GridLayout(1, 3));
        p7.setLayout(new GridLayout(1, 6));


        mainP.setBackground(Color.GREEN);
        p0.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        p5.setVisible(true);
        p6.setVisible(true);
        p7.setVisible(true);
        mainP.setVisible(true);

        int[][] board = {{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36},
                        {0,0,0,0,0,0,0,0,0,0,0,0}, 
                        {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
                        {0,0,0,0,0,0,0,0,0,0,0,0}, 
                        {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34},
                        {0,0,0,0,0,0,0,0,0,0,0,0}};
        
        Color[][] colors = {{Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                            {Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.BLACK},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
                            {Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED},
                            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE,Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE}};
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                JButton temp = new JButton(board[i][j] + " " + " ");
                temp.setContentAreaFilled(true);
                temp.setOpaque(true);
                temp.setBorderPainted(false);
                temp.setForeground(Color.WHITE);
                temp.setBackground(colors[i][j]);

                if (i == 0) {
                    p0.add(temp);
                }
                else if (i == 1) {
                    p1.add(temp);
                }
                else if (i == 2) {
                    p2.add(temp);
                }
                else if (i == 3) {
                    p3.add(temp);
                }
                else if (i == 4) {
                    p4.add(temp);
                }
                else if (i == 5) {
                    p5.add(temp);
                }
            }
        }

        String[] twelves = {"1st 12", "2nd 12", "3rd 12"};
        String[] bottom1 = {"1 to 18", "EVEN", "RED", "BLACK", "ODD", "19 to 36"};

        for (int x = 0; x < twelves.length; x++) {
            JButton temp2 = new JButton(twelves[x] + " " + " ");
            temp2.setContentAreaFilled(true);
            temp2.setOpaque(true);
            temp2.setBorderPainted(true);
            temp2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            temp2.setForeground(Color.WHITE);
            temp2.setBackground(Color.GREEN);
            p6.add(temp2);
        }

        for (int y = 0; y < bottom1.length; y++) {
            JButton temp3 = new JButton(bottom1[y] + " " + " ");
            temp3.setContentAreaFilled(true);
            temp3.setOpaque(true);
            temp3.setBorderPainted(true);
            temp3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            temp3.setForeground(Color.WHITE);
            temp3.setBackground(Color.GREEN);

            if (y == 2) {
                temp3.setBackground(Color.RED);
            }
            if (y == 3) {
                temp3.setBackground(Color.BLACK);
            }

            p7.add(temp3);
        }

        mainP.add(p0);
        mainP.add(p1);
        mainP.add(p2);
        mainP.add(p3);
        mainP.add(p4);
        mainP.add(p5);
        mainP.add(p6);
        mainP.add(p7);
        //f.add(mainP);
        f.setVisible(true);
    }
    

    public static void main(String[] args) {
        new SwingTest();
    }
}