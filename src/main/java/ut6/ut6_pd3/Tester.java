package ut6.ut6_pd3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Tester extends JFrame {
    private SortedListModel model;
    private JList<String> list;

    public Tester(String[] args) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        model = new SortedListModel();
        model.addAll(args);

        list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printAction();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(printButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void printAction() {
        Iterator<String> it = model.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        new Tester(args);
    }
}

