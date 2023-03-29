package GUI;

//********************************************
import java.awt.event.*;
import javax.swing.*;
/// ********************************************

public class LaunchPage implements ActionListener{
	 
	 JFrame frame = new JFrame();
	 JLabel title = new JLabel("Welcome to the Daily News Reporter. Please login or register below.");
	 JButton loginButton = new JButton("Login");
	 JButton registerButton = new JButton("Register");
	 
	 LaunchPage(){
	  
	  loginButton.setBounds(150,160,200,40);
	  registerButton.setBounds(150,260,200,40);
	  title.setBounds(100,100,500,40);
	  
	  loginButton.setFocusable(false);
	  registerButton.setFocusable(false);
	  
	  loginButton.addActionListener(this);
	  registerButton.addActionListener(this);
	  
	  frame.add(title);
	  frame.add(loginButton);
	  frame.add(registerButton);
	  
	  
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(1000,1000);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  
	 }

	 @Override
	 public void actionPerformed(ActionEvent e) {
	  
	  if(e.getSource() == loginButton) {
	   frame.dispose();
	   LoginFrame firstWindow = new LoginFrame();
	  }
	  
	  
	  if(e.getSource() == registerButton) {
		   frame.dispose();
		   RegistrationForm secondWindow = new RegistrationForm();
		  }
	 }
	}
