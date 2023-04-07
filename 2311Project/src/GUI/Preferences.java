package GUI;

import javax.swing.*;

import GUI.NewsFrame.BusinessNewsFrame;
import GUI.NewsFrame.EntertainmentNewsFrame;
import GUI.NewsFrame.GeneralNewsFrame;
import GUI.NewsFrame.HealthNewsFrame;
import GUI.NewsFrame.ScienceNewsFrame;
import GUI.NewsFrame.SportsNewsFrame;
import GUI.NewsFrame.TechnologyNewsFrame;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Preferences extends JFrame implements ActionListener {

    private JList<String> list;
    private JButton button;
    private JButton logoutButton;

    public Preferences() {
        setTitle("The Daily News Reporter Article Selection List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to display the current time
        JLabel timeLabel = new JLabel();
        timeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add an empty border to the label
        add(timeLabel, BorderLayout.WEST);

        // Set up a timer to update the time label every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
                String timeStr = dateFormat.format(new Date());
                // Update the time label
                timeLabel.setText("Current Time: " + timeStr);
            }
        });
        timer.start();
        
        // Create a button panel for the logout button and view calendar button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton viewCalendarButton = new JButton("View Calendar");
        viewCalendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the CalendarPanel
                JFrame calendarFrame = new JFrame();
                calendarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                calendarFrame.add(new CalendarPanel());
                calendarFrame.pack();
                calendarFrame.setLocationRelativeTo(null);
                calendarFrame.setVisible(true);
            }
        });
        buttonPanel.add(viewCalendarButton);

        // Create a button panel for the logout button
        JPanel buttonl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
        buttonPanel.add(logoutButton);

        // Add the button panel to the north position of the frame
        add(buttonPanel, BorderLayout.EAST);

        // Create a label to display instructions to the user
        JLabel label = new JLabel("Select a category in the list to view the articles related to the topic. To view multiple articles at the same time, press and hold the control/command line and select the articles you would like to view.");
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Add an empty border to the label
        add(label, BorderLayout.NORTH);

        // Create the list with checkboxes
        String[] items = {"Business", "Entertainment", "General", "Health", "Science", "Sports", "Technology"};
        list = new JList<String>(items);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(3);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);

        // Create the button to get selected items
        button = new JButton("View Selected Articles");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);

        setSize(1000, 1000);
        setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            ArrayList<String> selectedItems = new ArrayList<String>(list.getSelectedValuesList());
            String message = "You have selected: ";
            for (String item : selectedItems) {
                message += item + ", ";
            }
            message = message.substring(0, message.length() - 2); // Remove the last comma and space
            JOptionPane.showMessageDialog(this, message);

            // Display certain things based on the selected items
            if (selectedItems.contains("Business")) {
                new BusinessNewsFrame();
            }
            if (selectedItems.contains("Entertainment")) {
                new EntertainmentNewsFrame();
	            }
	            if (selectedItems.contains("General")) {
	            	new GeneralNewsFrame();
	                // Display something related to Item 2
	            }
	            if (selectedItems.contains("Health")) {
	            	new HealthNewsFrame();
	                // Display something related to Item 2
	            }
	            if (selectedItems.contains("Science")) {
	            	new ScienceNewsFrame();
	                // Display something related to Item 2
	            }
	            if (selectedItems.contains("Sports")) {
	            	new SportsNewsFrame();
	                // Display something related to Item 2
	            }
	            if (selectedItems.contains("Technology")) {
	            	new TechnologyNewsFrame();
	                // Display something related to Item 2
	            }
		}
		if (e.getSource() == logoutButton) {
			// Handle logout button click event
			JOptionPane.showMessageDialog(this, "You have logged out.");
			dispose(); // Close the preferences window
			
		}
	}
}
