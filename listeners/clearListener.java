package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clearListener implements ActionListener {

    private JTextArea input;
    private JTextArea output;
    private JTextField code;

    public clearListener(JTextArea input, JTextArea output, JTextField code) {
        this.input = input;
        this.output = output;
        this.code = code;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        input.setText(null);
        output.setText(null);
        code.setText(null);
    }
}
