package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Preferences extends JFrame implements ActionListener {

	private JList<String> list;
	private JButton button;


	public Preferences() {
		setTitle("Multiple Selection List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a label to display instructions to the user
		JLabel label = new JLabel("Select one or more items from the list: \n "
				+ "To select multiple items, hold down the control/command key.");
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
		button = new JButton("Get Selected Items");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);

		setSize(1000, 1000);
		setVisible(true);
	}

	// Handle button click events
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			ArrayList<String> selectedItems = new ArrayList<String>(list.getSelectedValuesList());
			//JOptionPane.showMessageDialog(this, "Selected Items: " + String.join(", ", selectedItems));
			 String message = "You have selected: ";
	            for (String item : selectedItems) {
	                message += item + ", ";
	            }
	            message = message.substring(0, message.length() - 2); // Remove the last comma and space
	            JOptionPane.showMessageDialog(this, message);
	            
	            // Display certain things based on the selected items
	            if (selectedItems.contains("Business")) {
	                // Display something related to Item 1
	            }
	            if (selectedItems.contains("Entertainment")) {
	                // Display something related to Item 2
	            }
	            // and so on...
		}
	}
}
