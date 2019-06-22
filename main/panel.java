package main;

import listeners.clearListener;
import listeners.inputListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class panel extends JPanel {
    public panel(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JTextArea input = new JTextArea(10,10);
        input.setBackground(new Color(0, 68, 166));
        input.setForeground(Color.white);
        input.setAutoscrolls(true);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.ipady = 200;
        c.fill = GridBagConstraints.BOTH;
        add(input, c);

        JTextArea output = new JTextArea(10,10);
        output.setEditable(false);
        output.setBackground(new Color(0, 68, 166));
        output.setForeground(Color.white);
        output.setAutoscrolls(true);
        c.gridx = 3;
        c.gridy = 0;
        add(output, c);

        JTextField code = new JTextField(2);
        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(code, c);

        JLabel label = new JLabel("Code :");
        label.setForeground(Color.cyan);
        label.setFont(new Font("Helvetica", Font.PLAIN, 18));
        c.gridx = 1;
        c.gridy = 1;
        c.fill = GridBagConstraints.CENTER;
        add(label, c);

        JButton go = new JButton("Traduire");
        go.addActionListener(new inputListener(input, output, code));
        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 0;
        c.fill = GridBagConstraints.CENTER;
        add(go, c);

        JButton clear = new JButton("Tout clear");
        clear.addActionListener(new clearListener(input, output, code));
        c.gridx = 1;
        c.gridy = 3;
        c.weighty = 1;
        add(clear, c);

        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(this.getClass().getResource("back.png"));
            g.drawImage(img, 0,0,this.getWidth(), this.getHeight(), null);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
