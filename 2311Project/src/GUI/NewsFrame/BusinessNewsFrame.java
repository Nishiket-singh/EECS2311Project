package GUI.NewsFrame;

import javax.swing.*;

import Data.Business;

import java.awt.*;

public class BusinessNewsFrame extends JFrame {

    public BusinessNewsFrame() {
        setTitle("Business News");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea headlinesArea = new JTextArea();
        headlinesArea.setEditable(false);
        JScrollPane headlinesScrollPane = new JScrollPane(headlinesArea);
        headlinesScrollPane.setPreferredSize(new Dimension(600, 100));
        add(headlinesScrollPane, BorderLayout.NORTH);

        JTextArea articleArea = new JTextArea();
        articleArea.setEditable(false);
        JScrollPane articleScrollPane = new JScrollPane(articleArea);
        articleScrollPane.setPreferredSize(new Dimension(600, 300)); 
        add(articleScrollPane, BorderLayout.CENTER);

        // Set the headlines and article text
        StringBuilder headlines = new StringBuilder();
        for (String headline : Business.headlines) {
            headlines.append(headline).append("\n");
        }
        headlinesArea.setText(headlines.toString());

        StringBuilder article = new StringBuilder();
        for (String paragraph : Business.article) {
            article.append(paragraph).append("\n");
        }
        articleArea.setText(article.toString());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
