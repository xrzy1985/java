import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.*;

public class Tutorial20 extends JFrame
{

	public static void main(String[] args)
	{

		new Tutorial20();

	}


	public Tutorial20()
	{
			// This is the size of the pop up in pixels
		this.setSize(400,400);

			// This will position the pop up relative to your screen
			// it will essentially center the screen
		//this.setLocationRelativeTo(null);

			// Toolkit is a superclass for the Abstract win toolkit
			// create a Toolkit object
		Toolkit tk = Toolkit.getDefaultToolkit();

			// create a dimension object, the object will hold
			// the size of the users screen
		Dimension dim = tk.getScreenSize();

			//
		int xPos = (dim.width / 2) - (this.getWidth() / 2);

		int yPos = (dim.height / 2) - (this.getHeight() / 2);

		this.setLocation(xPos,  yPos);

			// Define if the user will be able to resize the window
		this.setResizable(false);

			//	Must be defined in order for the frame to be exited
			// 	or Java will eventually close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title of the pop up frame window
		this.setTitle("My First Java Swing Frame");

			// Jpanel is what will contain all of the components of your frame
		JPanel panel = new JPanel();

			// This is how to create a simple label object to add
		JLabel label = new JLabel("Tell me something good.. ");

			// If you want to replace what text is in the label
		label.setText("This is the new text");

			// To set a tool tip to hover over a label
		label.setToolTipText("This doesn't do a thing really");

			// add the label to the JPanel
		panel.add(label);

			// To create a button
		JButton button = new JButton("Send information");

			// if you want to hide the button border
		//button.setBorderPainted(false);

			// Will change/eliminate the background
		//button.setContentAreaFilled(false);

			// To set the text on a button
		button.setText("Press Me");

			// To set a tool tip to hover over a button
		button.setToolTipText("This will hover over the button");

			// Add the button to the panel
		panel.add(button);

			// A text field
		JTextField textField = new JTextField("Type Here, mate", 15);

			// To Set the number of columns a text field has
		textField.setColumns(10);

			// To set the text in a text field
		textField.setText("This is the text in the text field");

			// A tool tip works with text fields also
		textField.setToolTipText("Tool tip for text field");

		panel.add(textField);

			// Text Areas
		JTextArea textArea = new JTextArea(15, 20);

			// To set the text of a text area
		textArea.setText("Text inside text area Text inside text area Text inside text area Text inside text area ");

			//
		textArea.setLineWrap(true);

			// This ensures that words do not get cut off half way through
		textArea.setWrapStyleWord(true);

			// This will get the appropriate number of lines
		int numberOfLines = textArea.getLineCount();

			// Need to append to a text area
		textArea.append(",             Number of Lines: " + numberOfLines);

			//
		panel.add(textArea);

			//
		JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			//
		panel.add(scrollBar);


			// To ensure that an area of the panel is focused on first
		textField.requestFocus();







			//
		this.add(panel);

			// This must be set to true in order to see the pop up
		this.setVisible(true);

	}
}
