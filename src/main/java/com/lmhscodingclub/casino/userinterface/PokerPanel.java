package com.lmhscodingclub.casino.userinterface;

import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import com.lmhscodingclub.casino.poker.Poker;

public class PokerPanel extends JPanel {
    PokerPanel() {
        super();
        JLabel l = new JLabel("Poker");
        JPanel box = new JPanel();
        box.setBorder(BorderFactory.createLineBorder(Color.black));

        add(actionButtons());

        add(l);
        add(box);
    }

    private JPanel actionButtons() {
        JPanel actionButtonStrip = new JPanel();

        JButton fold = new JButton("Fold");
        JButton call = new JButton("Call");
        JButton raise = new JButton("Raise");
        
        actionButtonStrip.add(fold);
        actionButtonStrip.add(call);
        actionButtonStrip.add(raise);

        return actionButtonStrip;
    }

    private void drawPoker(Graphics g) {

    }
}