package com.lmhscodingclub.casino.userinterface;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BlackjackPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Outer rect container
        g.drawRect(20, 20, 700, 500);

        // TITLE
        g.drawString("BLACKJACK", 400, 50);

    }
}