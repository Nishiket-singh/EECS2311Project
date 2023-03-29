package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

	JFrame frame;
	JLabel titleLabel = new JLabel("Welcome to The Daily News Reporter! "
			+ "Here you can find the latest news! To get started, please login into your account!");
	JLabel userLabel = new JLabel("Enter Username:");
	JLabel passwordLabel = new JLabel("Enter Password:");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JButton backButton = new JButton("BACK");
	JCheckBox showPassword = new JCheckBox("Show Password");


	LoginFrame()
	{
		//Calling methods inside constructor.
		createWindow();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}
	
	public void createWindow()
	{
		frame = new JFrame();
		frame.setTitle("The Daily News Reporter Login Form");

		frame.setBounds(100,100,900,750);
		frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}
	
	public void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		// setBounds (x, y, width, height)
		titleLabel.setBounds(100,50,3000,30);
		userLabel.setBounds(50,150,150,30);
		passwordLabel.setBounds(50,220,100,30);
		userTextField.setBounds(175,150,150,30);
		passwordField.setBounds(175,220,150,30);
		showPassword.setBounds(150,250,150,30);
		loginButton.setBounds(50,300,100,30);
		resetButton.setBounds(200,300,100,30);
		backButton.setBounds(125,350,100,30);


	}
	
	public void addComponentsToContainer()
	{
		//Adding each components to the Container
		frame.add(titleLabel);
		frame.add(userLabel);
		frame.add(passwordLabel);
		frame.add(userTextField);
		frame.add(passwordField);
		frame.add(showPassword);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(backButton);
	}

	public void addActionEvent()
	{
		//adding Action listener to components
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		backButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Coding Part of LOGIN button
		
		// this will be adapted to incorporate MYSQL in the later iteration
		if (e.getSource() == loginButton) {
			String userText;
			String pwdText;
			userText = userTextField.getText();
			pwdText = passwordField.getText();
			if (userText.equalsIgnoreCase("esha") && pwdText.equalsIgnoreCase("12345")) {
				JOptionPane.showMessageDialog(this, "Login Successful");
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}

		}
		
		//Coding Part of RESET button
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		
		//Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
		
		if (e.getSource() == backButton) {
			frame.dispose();
		LaunchPage previousWindow = new LaunchPage();
		}
	}
}
