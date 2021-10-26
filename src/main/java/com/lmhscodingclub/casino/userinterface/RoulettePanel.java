package com.lmhscodingclub.casino.userinterface;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RoulettePanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Outer rect container
        g.drawRect(20, 20, 700, 500);

        // TITLE
        g.drawString("ROULETTE", 400, 50);

        drawRouletteWheel(g);
        drawRouletteBoard(g);
    }

    private void drawRouletteWheel(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(350, 250, 200, 200);

        JButton spin = new JButton("Spin wheel");
        spin.setBounds(350, 250, 100, 50);

        add(spin);
    }

    private void drawRouletteBoard(Graphics g) {
        g.drawRect(600, 20, 100, 200);
        drawRow(g, 1);
        drawRow(g, 2);
        drawRow(g, 3);
    }

    private void drawRow(Graphics g, int rowNumber) {
        for (int i = rowNumber; i < rowNumber + 34; i += 3) {
            // g.drawRectangle()
        }
    }
}