package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;

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
		//frame.getContentPane().setBackground(Color.pink);
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
		if (e.getSource() == loginButton) {
			try {
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/User_Data","root","");
				String userText;
				String pwdText;
				userText = userTextField.getText();
				pwdText = passwordField.getText();
				PreparedStatement ps= connection.prepareStatement("select Login_info.password from Login_Info where Login_Info.username =?");
				ps.setString(1, userText);
				ResultSet rs2 = ps.executeQuery();
				rs2.next();
				if (rs2 != null && rs2.getString(1).equals(pwdText)) {
					//JOptionPane.showMessageDialog(this, "Login Successful");
					frame.dispose();
					Preferences nWindow = new Preferences();
				} else {
					JOptionPane.showMessageDialog(this, "Invalid Username or Password");
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
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
