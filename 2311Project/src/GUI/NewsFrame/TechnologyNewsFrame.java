package GUI.NewsFrame;

import javax.swing.*;

import Data.Technology;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TechnologyNewsFrame extends JFrame implements ActionListener {

	private JTextArea headlinesArea;
	private JTextArea articleArea;
	private JButton likeButton;
	private JButton dislikeButton;
	private Map<String, Integer> reactions; // map to store the number of reactions

	private JMenuBar menuBar;
	private JMenu optionsMenu;
	private JMenuItem lightModeMenuItem;
	private JMenuItem darkModeMenuItem;

	public TechnologyNewsFrame() {
		setTitle("Technology News");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		reactions = new HashMap<String, Integer>();
		reactions.put("like", 0);
		reactions.put("dislike", 0);

		// Set up the menu bar and options menu
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Options");
		lightModeMenuItem = new JMenuItem("Light Mode");
		darkModeMenuItem = new JMenuItem("Dark Mode");
		lightModeMenuItem.addActionListener(this);
		darkModeMenuItem.addActionListener(this);
		optionsMenu.add(lightModeMenuItem);
		optionsMenu.add(darkModeMenuItem);
		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);

		// Set up the headlines text area
		headlinesArea = new JTextArea();
		headlinesArea.setEditable(false);
		JScrollPane headlinesScrollPane = new JScrollPane(headlinesArea);
		headlinesScrollPane.setPreferredSize(new Dimension(600, 100));
		add(headlinesScrollPane, BorderLayout.NORTH);

		// Set up the article text area
		articleArea = new JTextArea();
		articleArea.setEditable(false);
		JScrollPane articleScrollPane = new JScrollPane(articleArea);
		articleScrollPane.setPreferredSize(new Dimension(600, 300));
		add(articleScrollPane, BorderLayout.CENTER);

		// Set up the like and dislike buttons
		likeButton = new JButton("Like");
		likeButton.addActionListener(this);
		dislikeButton = new JButton("Dislike");
		dislikeButton.addActionListener(this);

		JPanel reactionPanel = new JPanel(new FlowLayout());
		reactionPanel.add(likeButton);
		reactionPanel.add(dislikeButton);
		add(reactionPanel, BorderLayout.SOUTH);

		// Set the headlines and article text
		StringBuilder headlines = new StringBuilder();
		for (String headline : Technology.headlines) {
			headlines.append(headline).append("\n");
		}
		headlinesArea.setText(headlines.toString());

		StringBuilder article = new StringBuilder();
		for (String paragraph : Technology.article) {
			article.append(paragraph).append("\n");
		}
		articleArea.setText(article.toString());

		setLightMode();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Handle button click events and menu item selection
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == likeButton) {
			int currentCount = reactions.get("like");
			reactions.put("like", currentCount + 1);
			JOptionPane.showMessageDialog(this, "You liked this article!");
		}
		if (e.getSource() == dislikeButton) {
			int currentCount = reactions.get("dislike");
			reactions.put("dislike", currentCount + 1);
			JOptionPane.showMessageDialog(this, "You disliked this article!");
		}
		if (e.getSource() == lightModeMenuItem) {
			setLightMode();
		}
		if (e.getSource() == darkModeMenuItem) {
			setDarkMode();
		}
	}

	// Set the GUI to light mode
	private void setLightMode() {
		getContentPane().setBackground(Color.WHITE);
		headlinesArea.setBackground(Color.WHITE);
		headlinesArea.setForeground(Color.BLACK);
		articleArea.setBackground(Color.WHITE);
		articleArea.setForeground(Color.BLACK);
		
	}
	// Set the GUI to light mode
	private void setDarkMode() {
		getContentPane().setBackground(Color.GRAY);
		headlinesArea.setBackground(Color.GRAY);
		headlinesArea.setForeground(Color.WHITE);
		articleArea.setBackground(Color.GRAY);
		articleArea.setForeground(Color.WHITE);
	}

	//Override the dispose() method to display the reactions before closing the window
	@Override
	public void dispose() {
		JOptionPane.showMessageDialog(this, "This article has " + reactions.get("like") + " likes and " + reactions.get("dislike") + " dislikes.");
		super.dispose();
	}
}


