package com.lmhscodingclub.casino.userinterface;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.lmhscodingclub.casino.slots.Slots;

public class SlotsPanel extends JPanel {
    private int windowWidth;

    public SlotsPanel(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Outer rect container
        g.drawRect(20, 20, 700, 400);

        // Title
        g.drawString("SLOT", windowWidth / 2, 50);
        g.drawString("COINS", windowWidth / 3, 25);

        drawWheel(g, 1);
        drawWheel(g, 2);
        drawWheel(g, 3);

        // Actions
        g.drawString("BET", windowWidth / 3, 550);
        g.drawString("+", 75, 600);
        g.drawString("-", 150, 600);
        g.drawString("LINES", 650, 650);
        g.drawString("MAX BET", 100, 650);
        g.drawString("SPIN", 400, 650);
        g.drawString("AUTO", 100, 650);
        g.drawString("Total Bet: ", 450, 650);
    }

    private void drawWheel(Graphics g, int index) {
        g.drawRect(index * 100 + 50, 300, 75, 200);
    }
}
