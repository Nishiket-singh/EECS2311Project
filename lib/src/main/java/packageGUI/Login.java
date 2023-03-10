package packageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Login  {
	public static void main(String[] a){
		//Creating object of LoginFrame class and setting some of its properties
		LoginFrame frame = new LoginFrame();
		frame.setTitle("The Daily News Reporter Login Form");
		frame.setVisible(true);
		frame.setBounds(30,30,900,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setBackground(Color.PINK);

	}


}
