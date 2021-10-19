package com.lmhscodingclub.casino.userinterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UserInterface extends JFrame implements ItemListener {
    // Where instance variables are declared:
    JPanel cards;

    private CardLayout handleGameSwitch(Container pane) {
        CardLayout cardLayout = new CardLayout();

        final String ROULETTE = "Roulette";
        final String SLOTS = "Slots";
        final String POKER = "Poker";
        final String BLACKJACK = "Blackjack";

        // Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); // use FlowLayout
        String comboBoxItems[] = { ROULETTE, SLOTS, POKER, BLACKJACK };
        JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        // Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, SLOTS);
        cards.add(card2, POKER);
        cards.add(card2, ROULETTE);
        cards.add(card2, BLACKJACK);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);

        return cardLayout;
    }

    // Method came from the ItemListener class implementation,
    // contains functionality to process the combo box item selecting
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) evt.getItem());
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked
     * from the event dispatch thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Casino");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        UserInterface demo = new UserInterface();
        demo.handleGameSwitch(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}