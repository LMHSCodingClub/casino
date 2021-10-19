package com.lmhscodingclub.monopoly.userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Board extends JPanel {
    private int width = 500;
    private int height = 500;
    private Color boardColor = new Color(0, 125, 255);

    public Board() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GREEN);
        g2.setBackground(Color.GREEN);

        // Outer and inner borders
        g2.fill(new Rectangle2D.Double(62.5, 62.5, width, height));

        try {
            drawInnerRectangles(g2);
            drawProperties(g2);
            drawMonopolyLogo(g2);
            new ActionMenu();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void drawInnerRectangles(Graphics2D g2) throws IOException {
        // Rectangles on inside of board that are rotated 45 degrees
        AffineTransform old = g2.getTransform();

        // g2.rotate(Math.toRadians(-45));

        // Chance
        g2.setColor(new Color(255, 165, 0));
        g2.fill(new Rectangle2D.Double(100, 150, 100, 50));
        g2.fill(new Rectangle2D.Double(400, 150, 100, 50));
        // x, y, w, h

        // Community Chest
        g2.setColor(new Color(0, 165, 255));
        g2.fill(new Rectangle2D.Double(100, 400, 100, 50));
        g2.fill(new Rectangle2D.Double(400, 400, 100, 50));

        // Monopoly logo
        // drawMonopolyLogo(g2);

        g2.setTransform(old);
    }

    private void drawMonopolyLogo(Graphics2D g2) throws IOException {
        AffineTransform at = g2.getTransform();
        at.translate(250, 250);
        at.rotate(Math.toRadians(45));
        BufferedImage logo = ImageIO.read(new File("/images/logo.png"));
        g2.drawImage(logo, at, null);
    }

    private void drawProperties(Graphics2D g2) {
        // Properties
        // x, y, w, h

        final float TILE_WIDTH = 41.6f;
        final float TILE_HEIGHT = 62.4f;
        final float TILE_OFFSET_X = 41.6f;
        final float TILE_OFFSET_Y = 499.1f;

        g2.setColor(Color.BLACK);
        Paint blackBorderWhiteFill = new GradientPaint(0, 0, Color.WHITE, TILE_WIDTH, TILE_HEIGHT, Color.BLACK);
        g2.setPaint(blackBorderWhiteFill);
        g2.setBackground(Color.GREEN);

        // Dimensions of tile: length - TILE_WIDTH, width - 41.6, corner tiles -
        // TILE_WIDTH X TILE_WIDTH

        // Top and bottom rows
        for (int i = 0; i < 10; i++) {
            // Top
            createPropertyTile(g2, i * TILE_HEIGHT + TILE_OFFSET_X, TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);

            // Bottom
            createPropertyTile(g2, i * TILE_HEIGHT + TILE_OFFSET_X, TILE_OFFSET_Y, TILE_WIDTH, TILE_HEIGHT);
        }

        // Left and right columns
        for (int q = 1; q <= 8; q++) {
            createPropertyTile(g2, TILE_OFFSET_X + 20, TILE_HEIGHT * q, TILE_HEIGHT + TILE_OFFSET_X, TILE_OFFSET_X);
            createPropertyTile(g2, TILE_OFFSET_X + 520, TILE_HEIGHT * q, TILE_HEIGHT + TILE_OFFSET_X, TILE_OFFSET_X);
        }
    }

    private void createPropertyTile(Graphics2D g2, float x, float y, float w, float h) {
        g2.setPaint(boardColor);
        g2.fill(new Rectangle2D.Double(x, y, w, h));
        g2.setPaint(Color.BLACK);
        
        Rectangle2D.Double propertyTile = new Rectangle2D.Double(x, y, w, h);
        g2.draw(propertyTile);

        boolean isSelected = propertyTile.isSelected();
    }
    
}