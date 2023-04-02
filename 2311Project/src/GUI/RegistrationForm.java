package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;


public class RegistrationForm extends JFrame implements ActionListener {
	JFrame frame;
	JLabel titleLabel = new JLabel("Welcome to The Daily News Reporter! "
			+ "Here you can find the latest news! To get started, please register to get started!");
	String[] gender = {"Female","Male", "Non-Binary", "Other"};
	JLabel firstNameLabel = new JLabel("First Name:");
	JLabel lastNameLabel = new JLabel("Last Name:");
	JLabel genderLabel = new JLabel("Gender");
	JLabel ageLabel = new JLabel("Age:");
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
	JLabel IDLabel = new JLabel("ID:");
	JLabel countryLabel = new JLabel("Country:");
	JLabel emailLabel = new JLabel("Email:");

	JTextField firstNameTextField = new JTextField();
	JTextField lastNameTextField = new JTextField();
	JComboBox genderComboBox = new JComboBox(gender); 
	JTextField ageTextField = new JTextField();
	JTextField usernameTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JTextField IDTextField = new JTextField();
	JTextField countryTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	JButton submitButton = new JButton("SUBMIT");
	JButton clearButton = new JButton("CLEAR");
	JButton backButton = new JButton("BACK");
	JCheckBox showPassword = new JCheckBox("Show Password");


	RegistrationForm()
	{
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}


	public void createWindow()
	{
		frame = new JFrame();
		frame.setTitle("The Daily News Reporter Registration Form");

		frame.setBounds(100,100,900,750);
		//frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}
	public void setLocationAndSize()
	{
		titleLabel.setBounds(100,10,3000,30);
		firstNameLabel.setBounds(20,20,80,70); 
		lastNameLabel.setBounds(20,70,80,70); //update
		genderLabel.setBounds(20,120,80,70);
		ageLabel.setBounds(20,170,100,70); 
		usernameLabel.setBounds(20,220,100,70); // update
		passwordLabel.setBounds(20,270,100,70);
		showPassword.setBounds(200,320,150,30); // update
		confirmPasswordLabel.setBounds(20,370,140,70);
		IDLabel.setBounds(20,420,100,70);
		countryLabel.setBounds(20,470,100,70); //update
		emailLabel.setBounds(20,520,100,70);

		firstNameTextField.setBounds(180,43,165,23);
		lastNameTextField.setBounds(180,93,165,23); //update
		genderComboBox.setBounds(180,143,165,23);
		ageTextField.setBounds(180,193,165,23);
		usernameTextField.setBounds(180,243,165,23); //update
		passwordField.setBounds(180,293,165,23);
		confirmPasswordField.setBounds(180,393,165,23);
		IDTextField.setBounds(180,443,165,23);
		countryTextField.setBounds(180,493,165,23); //update 
		emailTextField.setBounds(180,543,165,23);
		submitButton.setBounds(70,593,100,35);
		clearButton.setBounds(220,593,100,35);
		backButton.setBounds(150,650,100,30);
	}
	public void addComponentsToFrame()
	{
		frame.add(titleLabel);
		frame.add(firstNameLabel);
		frame.add(lastNameLabel);
		frame.add(genderLabel);
		frame.add(ageLabel);
		frame.add(usernameLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(showPassword);
		frame.add(IDLabel);
		frame.add(countryLabel);
		frame.add(emailLabel);

		frame.add(firstNameTextField);
		frame.add(lastNameTextField);
		frame.add(genderComboBox);
		frame.add(ageTextField);
		frame.add(usernameTextField);
		frame.add(passwordField);
		frame.add(confirmPasswordField);
		frame.add(IDTextField);
		frame.add(countryTextField);
		frame.add(emailTextField);
		frame.add(submitButton);
		frame.add(clearButton);
		frame.add(backButton);
	}

	public void actionEvent()
	{
		submitButton.addActionListener(this);
		clearButton.addActionListener(this);
		showPassword.addActionListener(this);
		backButton.addActionListener(this);
	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		//Coding Part of Submit button

        if(e.getSource()==submitButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/User_Data","root","");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("Insert into person_info(name,age,gender,ID)" + " VALUES(? ,? ,? ,?)");
                PreparedStatement Pstatement1 = connection.prepareStatement("Insert into Login_Info(ID, Username, Password)" + "VALUES(? , ? , ?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,firstNameTextField.getText());
                Pstatement.setString(2,ageTextField.getText());
                Pstatement.setString(3,genderComboBox.getSelectedItem().toString());
                Pstatement.setInt(4,Integer.parseInt(IDTextField.getText()));
                
                Pstatement1.setInt(1,Integer.parseInt(IDTextField.getText()));
                Pstatement1.setString(2, usernameTextField.getText());
                Pstatement1.setString(3, passwordField.getText());
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.execute();
                    Pstatement1.execute();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }

		//Coding Part of Clear button
		if (e.getSource() == clearButton) {
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			genderComboBox.setSelectedItem("Female");
			ageTextField.setText("");
			passwordField.setText("");
			confirmPasswordField.setText("");
			IDTextField.setText("");
			countryTextField.setText("");
			emailTextField.setText("");
			usernameTextField.setText("");
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
