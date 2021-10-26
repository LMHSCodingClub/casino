package com.lmhscodingclub.casino.userinterface;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lmhscodingclub.casino.poker.Poker;

public class PokerPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Outer rect container
        g.drawRect(20, 20, 700, 500);

        // TITLE
        g.drawString("POKER", 400, 50);

    }

    private void drawPoker(Graphics g) {

    }
}