// package com.khanhtran0111;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShapeAnimation {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(new Point(50, 50), 30, "#FF0000", true));
        shapes.add(new Rectangle(new Point(100, 100), 60, 40, "#0000FF", true));

        LayerPanel panel = new LayerPanel(shapes);

        JFrame frame = new JFrame("Shape Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.animateShapes();
            }
        });
        timer.start();
    }
}
