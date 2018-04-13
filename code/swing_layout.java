import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Tutorial28 extends JFrame
{
	JButton button1, button2, button3, button4, button5;

	String outputString = "";

	public static void main(String[] args)
	{
		new Tutorial28();
	}

	public Tutorial28()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Eighth Frame Tutorial");

			//
		JPanel panel = new JPanel();

		// panel.setLayout(new FlowLayout(FlowLayout.LEFT));

			// FlowLayout.WHICHEVER, horizontalGap, verticalGap
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 75, 20));

		button1 = new JButton("Button 1");

		button2 = new JButton("Button 2");

		panel.add(button1);

		panel.add(button2);

			// How to use BorderLayout
		panel.setLayout(new BorderLayout());

			// Create the buttons to correspond to the locations
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		button5 = new JButton("Button 5");

			// North, West, East, South, Center
		// panel.add(button1, BorderLayout.NORTH);

		// panel.add(button2, BorderLayout.WEST);

		// panel.add(button3, BorderLayout.EAST);

		// panel.add(button4, BorderLayout.SOUTH);

			// Center will always be the largest
		// panel.add(button5, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();

		panel2.add(button1);

		panel2.add(button2);

		panel.add(panel2, BorderLayout.NORTH);

		this.add(panel);

		this.setVisible(true);

	}

}

//-------------------------------------------------------------
//-------------------------------------------------------------


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Tutorial28_2 extends JFrame
{
	JButton button1, button2, button3, button4, button5;

	String outputString = "";

	public static void main(String[] args)
	{
		new Tutorial28_2();
	}

	public Tutorial28_2()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Eighth Frame Tutorial");

			// Define the box
		Box theBox = Box.createHorizontalBox();

		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		button5 = new JButton("Button 5");

		/*
		theBox.add(button1);
		theBox.add(Box.createHorizontalStrut(20));
		theBox.add(button2);
		theBox.add(Box.createHorizontalStrut(20));
		theBox.add(button3);
		theBox.add(Box.createHorizontalStrut(20));
		theBox.add(button4);
		*/

		/*
		theBox.add(button1);
		theBox.add(Box.createHorizontalStrut(20));
		theBox.add(button2);
		theBox.add(Box.createHorizontalGlue());
		theBox.add(button3);
		*/

		theBox.add(button1);
		theBox.add(Box.createHorizontalStrut(20));
		theBox.add(button2);
		theBox.add(Box.createRigidArea(new Dimension(5, 50)));
		theBox.add(button3);

		this.add(theBox);

		this.setVisible(true);

	}

}
