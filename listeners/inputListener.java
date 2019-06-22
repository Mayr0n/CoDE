package listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class inputListener implements ActionListener {

    private JTextArea input;
    private JTextArea output;
    private JTextField code;

    public inputListener(JTextArea input, JTextArea output, JTextField code){
        this.input = input;
        this.output = output;
        this.code = code;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(code.getText().length() == 2) {
            char p = code.getText().charAt(0);
            char s = code.getText().charAt(1);
            List<String> lines = Arrays.asList(input.getText().split("\n"));
                List<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
                int i = 0;
                int pNum = 999;
                int sNum = 999;

                for (char letter : alphabet) {
                    if (p == letter) {
                        pNum = i;
                    }
                    if (s == letter) {
                        sNum = i;
                    }
                    i++;
                }
                if (pNum != 999 && sNum != 999) {
                    final int toChange = sNum - pNum;
                    i = 0;
                    output.setText("");
                    for (String line : lines) { //s'exécute pour chaque ligne du fichier
                        for (char l : line.toCharArray()) { //s'exécute pour chaque lettre de la ligne "line"
                            if (!alphabet.contains(l)) { //si l n'est pas dans l'alphabet => réécrit tel quel
                                output.append(String.valueOf(l));
                            } else {
                                for (char letter : alphabet) { //si l est une lettre => teste chaque lettre du tableau alphabet[] afin de connaître le numéro de la lettre l dans l'alphabet
                                    if (l == letter) {
                                        int newLetNum = i + toChange;
                                        if (newLetNum < 0) {
                                            newLetNum = 26 + newLetNum;
                                        }
                                        if (newLetNum >= 26) {
                                            newLetNum = newLetNum - 26;
                                        }
                                        output.append(String.valueOf(alphabet.get(newLetNum)));
                                        i = 0;
                                    }
                                    i++;
                                }
                                i = 0;
                            }
                        }
                        output.append("\n");
                    }
                    input.setText(" ");
                } else {
                    output.setText("Les deux lettres du code doivent être en minuscule ! \n Exemple : \"ab\"");
                }
        } else {
            output.setText("Il doit avoir deux lettres dans le code ! \n Exemple : \"ok\"");
        }
    }
}
