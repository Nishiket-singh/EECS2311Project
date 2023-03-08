package loginPageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel titleLabel = new JLabel("The Daily News Reporter");
	JLabel userLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");


	
