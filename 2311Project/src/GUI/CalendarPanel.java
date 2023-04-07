package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalendarPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel monthLabel;
	private JPanel daysPanel;
	private JButton previousButton;
	private JButton nextButton;

	private LocalDate currentDate;

	public CalendarPanel() {
		setLayout(new BorderLayout());

		// Set up the top panel with the month label and navigation buttons
		JPanel topPanel = new JPanel(new BorderLayout());
		monthLabel = new JLabel("", SwingConstants.CENTER);
		topPanel.add(monthLabel, BorderLayout.CENTER);

		previousButton = new JButton("<");
		previousButton.addActionListener(this);
		topPanel.add(previousButton, BorderLayout.WEST);

		nextButton = new JButton(">");
		nextButton.addActionListener(this);
		topPanel.add(nextButton, BorderLayout.EAST);

		add(topPanel, BorderLayout.NORTH);

		// Set up the panel for the days of the month
		daysPanel = new JPanel(new GridLayout(0, 7));
		add(daysPanel, BorderLayout.CENTER);

		// Set the current date to today
		currentDate = LocalDate.now();

		// Draw the calendar
		drawCalendar();
	}

	private void drawCalendar() {
		    // Clear the current calendar
		    daysPanel.removeAll();

		    // Set the month label to show the current month and year
		    String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
		    String year = Integer.toString(currentDate.getYear());
		    monthLabel.setText(month + " " + year);

		    // Get the number of days in the current month
		    int numDays = currentDate.getMonth().length(currentDate.isLeapYear());

		    // Get the starting day of the month
		    LocalDate firstOfMonth = currentDate.withDayOfMonth(1);
		    int startDay = firstOfMonth.getDayOfWeek().getValue();

		    // Add labels for the weekdays
		    String[] weekdayNames = new DateFormatSymbols(Locale.getDefault()).getShortWeekdays();
		    for (int i = 1; i < weekdayNames.length; i++) {
		        JLabel weekdayLabel = new JLabel(weekdayNames[i], SwingConstants.CENTER);
		        weekdayLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		        weekdayLabel.setFont(new Font("Arial", Font.BOLD, 20));
		        weekdayLabel.setOpaque(true);
		        weekdayLabel.setBackground(Color.LIGHT_GRAY);
		        daysPanel.add(weekdayLabel);
		    }

		    // Add blank labels for days before the start of the month
		    for (int i = 1; i < startDay; i++) {
		        JLabel label = new JLabel("");
		        daysPanel.add(label);
		    }

		    // Add labels for each day of the month
		    for (int i = 1; i <= numDays; i++) {
		        JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
		        label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		        label.setFont(new Font("Arial", Font.BOLD, 20));
		        label.setOpaque(true);
		        label.setBackground(Color.WHITE);
		        daysPanel.add(label);
		    }

		    // Add blank labels for days after the end of the month
		    int numBlankDays = 7 - ((startDay + numDays - 1) % 7 + 1);
		    for (int i = 0; i < numBlankDays; i++) {
		        JLabel label = new JLabel("");
		        daysPanel.add(label);
		    }

		    // Redraw the panel
		    revalidate();
		    repaint();
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == previousButton) {
			// Go to the previous month
			currentDate = currentDate.minusMonths(1);
			drawCalendar();
		} else if (e.getSource() == nextButton) {
			// Go to the next month
			currentDate = currentDate.plusMonths(1);
			drawCalendar();
		} else {
			// Find the day that was clicked
			int day = Integer.parseInt(((JButton) e.getSource()).getText());
			LocalDate selectedDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), day);
		}

	}
}