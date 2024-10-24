// package com.khanhtran0111;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LayerPanel extends JPanel {
    private List<Shape> shapes;

    public LayerPanel(List<Shape> shapes) {
        this.shapes = shapes;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void animateShapes() {
        for (Shape shape : shapes) {
            shape.move();
        }
        repaint();
    }
}
