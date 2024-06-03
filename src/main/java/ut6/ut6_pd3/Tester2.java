package ut6.ut6_pd3;

import javax.swing.*;
import java.awt.*;

public class Tester2 extends JFrame {
    public Tester2(String[] args) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        ArrayListComboBoxModel model = new ArrayListComboBoxModel();
        for (String arg : args) {
            model.addElement(arg);
        }

        JComboBox<String> comboBox = new JComboBox<>(model);
        getContentPane().add(comboBox, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Tester(args);
    }
}
