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
        StringBuilder article = new StringBuilder();
        for (String headline : Business.headlines) {
            for (String paragraph : Business.article) {
                headlines.append(headline).append("\n");
                article.append(paragraph).append("\n");
        }
        }
        headlinesArea.setText(headlines.toString());
        articleArea.setText(article.toString());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
