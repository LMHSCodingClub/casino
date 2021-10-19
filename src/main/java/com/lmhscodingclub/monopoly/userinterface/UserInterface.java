package com.lmhscodingclub.monopoly.userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

class UserInterface extends JFrame implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private int player;
    private int numPlayers;
    private JLabel jPlayer;

    public static void main(String[] args) {
        new UserInterface();
    }

    public UserInterface() {
        // Font mainFont = new Font("Arial", Font.PLAIN, 20);
        // just placeholders for now
        numPlayers = 6;
        player = 1;
        int balance = 1500;

        JPanel sideBar = new JPanel();
        sideBar.setBackground(Color.LIGHT_GRAY);
        sideBar.setPreferredSize(new Dimension(300, 0));

        jPlayer = new JLabel("Player: " + player);
        JLabel jBalance = new JLabel("Current Balance: $" + balance);

        JLabel firstDie = new JLabel(); 
        JLabel secondDie = new JLabel();
        JButton rollDice = createRollDiceButton(firstDie, secondDie);
            
        JPanel tradingMenu = new JPanel();

        JButton tradeProperty = new JButton("Trade Property");
        tradeProperty.addActionListener(e -> {
            if (tradingMenu.isVisible()){
                tradingMenu.setVisible(false);
            } else {
                tradingMenu.setVisible(true);
            }
        });
        
        JButton nextTurn = createNextTurnButton(firstDie, secondDie, rollDice);

        tradingMenu.setLayout(new BoxLayout(tradingMenu, BoxLayout.Y_AXIS));
        
        JLabel trade = new JLabel("Trade");
        trade.setFont(new Font("Arial", Font.BOLD, 40));

        JLabel amountGivingLabel = new JLabel("Amount Giving: ");

        tradingMenu.add(trade);
        tradingMenu.add(amountGivingLabel);
        tradingMenu.add(new NumberField());
        tradingMenu.add(new JLabel("Amount Taking: "));
        tradingMenu.add(new NumberField());
        tradingMenu.setVisible(false);

        sideBar.setLayout(new FlowLayout());
        sideBar.add(jPlayer);
        sideBar.add(jBalance);
        sideBar.add(rollDice);
        sideBar.add(tradeProperty);
        sideBar.add(nextTurn);
        sideBar.add(tradingMenu);
        sideBar.add(firstDie);
        sideBar.add(secondDie);
        add(sideBar, BorderLayout.EAST);

        // board
        JPanel template = new JPanel();
        JPanel board = new JPanel();
        board.setBackground(Color.decode("#cde6d0"));
        board.setPreferredSize(new Dimension(650, 650));
        board.setLayout(new GridBagLayout());
        board.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        JLabel logo = createLogo();
        template.add(board, BorderLayout.CENTER);
        board.add(logo);
        add(template);

        // spaces
        // JButton button = new JButton("Test");
        // board.add(button);
        // JButton button1 = new JButton("Test");
        // board.add(button1);

        add(new Board());

        // set resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.getHeight());
        int width = (int) (screenSize.getWidth());
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Monopoly");
    }

    private JButton createRollDiceButton(JLabel firstDie, JLabel secondDie) {
        JButton rollDice = new JButton("Roll Dice");
        
        rollDice.addActionListener((e) -> {   
            firstDie.setIcon(new ImageIcon());
            secondDie.setIcon(new ImageIcon());

            int firstDieNum = (int) Math.round(Math.random() * 5) + 1;
            int secondDieNum = (int) Math.round(Math.random() * 5) + 1;
            
            // Constrain to 2 and 12
            int result = Math.max(2, Math.min(firstDieNum + secondDieNum, 12));
            //System.out.println(result);

            // Animated Dice (first and second)
            createDiceIcon(firstDie, firstDieNum);
            createDiceIcon(secondDie, secondDieNum);
            revalidate();

            // Disables button after use. The button will be re-enabled once a new turn begins
            rollDice.setEnabled(false);
        });
        
        return rollDice;
    }

    private void createDiceIcon(JLabel die, int dieNum){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("./gifs/die_" + dieNum + ".gif"));
        ii.getImage().flush();
        die.setIcon(ii);

    }

    private JLabel createLogo() {
        JLabel logo = new JLabel("MONOPOLY");
        logo.setFont(new Font("Arial Black", Font.BOLD, 50));
        logo.setOpaque(true);
        logo.setBackground(Color.RED);
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
        return logo;
    }

    private JButton createNextTurnButton(JLabel firstDie, JLabel secondDie, JButton rollDice) {
        JButton nextTurn = new JButton("Next Turn");

        nextTurn.addActionListener(e -> {
            player = player % numPlayers + 1;
            jPlayer.setText("Player: " + player);
            
            // Reset
            firstDie.setIcon(new ImageIcon());
            secondDie.setIcon(new ImageIcon());
            rollDice.setEnabled(true);

        });

        return nextTurn;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
        
    }
}