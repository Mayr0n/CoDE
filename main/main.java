package main;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CoDe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 500);
        frame.setAlwaysOnTop(true);
        frame.setContentPane(new panel());
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
