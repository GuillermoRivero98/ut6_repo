package ut6.ut6_pd3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Tester3 extends JFrame {
    private WordCount wordCount;
    private JTextArea textArea;
    private JTextField urlField;

    public Tester3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        wordCount = new WordCount();
        textArea = new JTextArea();
        urlField = new JTextField();

        JButton fetchButton = new JButton("Fetch");
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchWords();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearWords();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(urlField, BorderLayout.CENTER);
        panel.add(fetchButton, BorderLayout.EAST);
        panel.add(clearButton, BorderLayout.WEST);

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void fetchWords() {
        wordCount.clear();
        textArea.setText("");

        try {
            URL url = new URL(urlField.getText());
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount.addWords(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        textArea.setText(wordCount.convertMap());
    }

    private void clearWords() {
        wordCount.clear();
        textArea.setText("");
        urlField.setText("");
    }

    public static void main(String[] args) {
        new Tester3();
    }
}
