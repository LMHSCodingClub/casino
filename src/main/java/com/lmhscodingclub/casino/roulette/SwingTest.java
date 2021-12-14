import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericDeclaration;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.net.URL;
import java.net.http.WebSocket;

import javax.imageio.ImageIO;

public class SwingTest {
    public SwingTest() {
        startUpGame();
    }
    
    public static void startUpGame() {
        JFrame f = new JFrame("Roulette");
        //f.setSize(900,450);
        f.setBounds(0, 0, 1200, 600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.GREEN);

        JLayeredPane lPane = new JLayeredPane();
        //lPane.setLayout(new BorderLayout());
        lPane.setBounds(0, 0, 1079, 407);
        lPane.setVisible(true);
        lPane.setBackground(Color.GREEN);

        JPanel mainP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();

        JPanel mainP2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p14 = new JPanel();

        //mainP.setPreferredSize(new Dimension(800, 407));
        mainP.setBounds(83, 50, 988, 407);
        mainP2.setBounds(75, 50, 1004, 249);
        p0.setPreferredSize(new Dimension(988, 75));
        p1.setPreferredSize(new Dimension(988, 8));
        p2.setPreferredSize(new Dimension(988, 75));
        p3.setPreferredSize(new Dimension(988, 8));
        p4.setPreferredSize(new Dimension(988, 75));
        p5.setPreferredSize(new Dimension(988, 8));
        p6.setPreferredSize(new Dimension(988, 75));
        p7.setPreferredSize(new Dimension(988, 75));
        p8.setPreferredSize(new Dimension(1004, 75));
        p9.setPreferredSize(new Dimension(1004, 8));
        p10.setPreferredSize(new Dimension(1004, 75));
        p11.setPreferredSize(new Dimension(1004, 8));
        p12.setPreferredSize(new Dimension(1004, 75));
        p13.setPreferredSize(new Dimension(1004, 8));
        p14.setPreferredSize(new Dimension(75, 125));

        p0.setLayout(new GridLayout(1, 12, 8, 0));
        p1.setLayout(new GridLayout(1, 12, 8, 0));
        p2.setLayout(new GridLayout(1, 12, 8, 0));
        p3.setLayout(new GridLayout(1, 12, 8, 0));
        p4.setLayout(new GridLayout(1, 12, 8, 0));
        p5.setLayout(new GridLayout(1, 12, 8, 0));
        p6.setLayout(new GridLayout(1, 3, 8, 0));
        p7.setLayout(new GridLayout(1, 6, 8, 0));
        p8.setLayout(new GridLayout(1, 13, 75, 0));
        p9.setLayout(new GridLayout(1, 13, 75, 0));
        p10.setLayout(new GridLayout(1, 13, 75, 0));
        p11.setLayout(new GridLayout(1, 13, 75, 0));
        p12.setLayout(new GridLayout(1, 13, 75, 0));
        p13.setLayout(new GridLayout(1, 13, 75, 0));
        //p14.setLayout();

        mainP.setBackground(Color.GREEN);
        mainP2.setBackground(Color.GREEN);
        p0.setBackground(Color.GREEN);
        p1.setBackground(Color.GREEN);
        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.GREEN);
        p4.setBackground(Color.GREEN);
        p5.setBackground(Color.GREEN);
        p6.setBackground(Color.GREEN);
        p7.setBackground(Color.GREEN);
        p8.setBackground(Color.GREEN);
        p9.setBackground(Color.GREEN);
        p10.setBackground(Color.GREEN);
        p11.setBackground(Color.GREEN);
        p12.setBackground(Color.GREEN);
        p13.setBackground(Color.GREEN);
        p14.setBackground(Color.GREEN);

        p0.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);
        p3.setVisible(true);
        p4.setVisible(true);
        p5.setVisible(true);

        p6.setVisible(true);
        p7.setVisible(true);

        p8.setVisible(true);
        p9.setVisible(true);
        p10.setVisible(true);
        p11.setVisible(true);
        p12.setVisible(true);
        p13.setVisible(true);
        p14.setVisible(true);

        mainP.setVisible(true);
        mainP2.setVisible(true);

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
                temp.setBorderPainted(true);
                temp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
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

        for (int a = 0; a < 13; a++) {
            JButton temp4 = new JButton("0" + " " + " ");
            temp4.setContentAreaFilled(true);
            temp4.setOpaque(true);
            temp4.setBorderPainted(true);
            temp4.setForeground(Color.WHITE);
            temp4.setBackground(Color.WHITE);
            p8.add(temp4);
        }

        for (int b = 0; b < 13; b++) {
            JButton temp5 = new JButton("0" + " " + " ");
            temp5.setContentAreaFilled(true);
            temp5.setOpaque(true);
            temp5.setBorderPainted(true);
            temp5.setForeground(Color.WHITE);
            temp5.setBackground(Color.WHITE);
            p9.add(temp5);
        }

        for (int c = 0; c < 13; c++) {
            JButton temp6 = new JButton("0" + " " + " ");
            temp6.setContentAreaFilled(true);
            temp6.setOpaque(true);
            temp6.setBorderPainted(true);
            temp6.setForeground(Color.WHITE);
            temp6.setBackground(Color.WHITE);
            p10.add(temp6);
        }

        for (int d = 0; d < 13; d++) {
            JButton temp7 = new JButton("0" + " " + " ");
            temp7.setContentAreaFilled(true);
            temp7.setOpaque(true);
            temp7.setBorderPainted(true);
            temp7.setForeground(Color.WHITE);
            temp7.setBackground(Color.WHITE);
            p11.add(temp7);
        }

        for (int e = 0; e < 13; e++) {
            JButton temp8 = new JButton("0" + " " + " ");
            temp8.setContentAreaFilled(true);
            temp8.setOpaque(true);
            temp8.setBorderPainted(true);
            temp8.setForeground(Color.WHITE);
            temp8.setBackground(Color.WHITE);
            p12.add(temp8);
        }

        for (int g = 0; g < 13; g++) {
            JButton temp9 = new JButton("0" + " " + " ");
            temp9.setContentAreaFilled(true);
            temp9.setOpaque(true);
            temp9.setBorderPainted(true);
            temp9.setForeground(Color.WHITE);
            temp9.setBackground(Color.WHITE);
            p13.add(temp9);
        }

        JButton temp10 = new JButton("00" + " " + " ");
        temp10.setContentAreaFilled(true);
        temp10.setOpaque(true);
        temp10.setBorderPainted(true);
        temp10.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        temp10.setForeground(Color.WHITE);
        temp10.setBackground(Color.GREEN);
        p14.add(temp10);

        mainP.add(p0);
        mainP.add(p1);
        mainP.add(p2);
        mainP.add(p3);
        mainP.add(p4);
        mainP.add(p5);
        mainP.add(p6);
        mainP.add(p7);
        mainP2.add(p8);
        mainP2.add(p9);
        mainP2.add(p10);
        mainP2.add(p11);
        mainP2.add(p12);
        mainP2.add(p13);

        lPane.add(mainP);
        lPane.add(mainP2);
        lPane.add(p14);
        f.setContentPane(lPane);

        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SwingTest();
    }
}
