import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Tutorial21 extends JFrame
{

	JButton button1;
	JTextField textField1;
	JTextArea textArea1;
	int buttonClicked;


	public static void main(String[] args)
	{
		new Tutorial21();
	}

	public Tutorial21()
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

			// dim.width will return the width of the screen
			// this.getWidth returns the predefined width for this object
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);

			// This will set the location of the pop up via (x,y)
		this.setLocation(xPos,  yPos);

			//		Must be defined in order for the frame to be exited
			// 	or Java will eventually close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title of the pop up frame window
		this.setTitle("My Second Frame");

			// Jpanel is what will contain all of the components of your frame
		JPanel panel = new JPanel();

			// Create the button object
		button1 = new JButton("Click Me");

			// Create instance of ListenForEvents to handle the events
		ListenForButton buttonListener = new ListenForButton();

			// Alerts the user when an event occurs on the button1
		button1.addActionListener(buttonListener);

			// Add the button to the panel
		panel.add(button1);

			// Create a JTextField
		textField1 = new JTextField("Type Here", 15);

			// Create instance of ListenForKeys
		ListenForKeys keyListener = new ListenForKeys();

			//
		textField1.addKeyListener(keyListener);

			//
		panel.add(textField1);

			//	Create text area
		textArea1 = new JTextArea(15, 20);

			//	Set default text inside text area
		textArea1.setText("Tracking Events \n");

			//	If it will not fit on one line, jump to the next
		textArea1.setLineWrap(true);

			//	Ensures that lines stay intact if a line wrap occurs
		textArea1.setWrapStyleWord(true);

			//
		panel.add(textArea1);

			//	Add scroll bar to text area
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

			// Add scroll bar to the panel
		panel.add(scrollbar1);

			//	add the panel to the object currently being used
		this.add(panel);

			//	Creates instance  of ListenForWindow
		ListenForWindow forWindow = new ListenForWindow();

			// Tracks what the user does with the opened window
			// open, minimize, close, or etc
		this.addWindowListener(forWindow);

			// Creates instance  of ListenForWindow
		ListenForMouse forMouse = new ListenForMouse();

			// tracks the mouse if it is inside of the panel
		this.addMouseListener(forMouse);

			// Must be set to true in order to be visible
		this.setVisible(true);

	}


		// ActionListener will react to events on components
	private class ListenForButton implements ActionListener
	{
		// This is the method called when events occur
		public void actionPerformed(ActionEvent e)
		{
				// Check to see if the button was triggered
			if(e.getSource() == button1)
			{
					// This will increment buttonClicked by one every
					// time the button is clicked on
				buttonClicked++;

					// This will add the text to the textArea every
					// time this method is called
				textArea1.append("Button Clicked: " + buttonClicked  + "\n");

				System.out.println("===================================");
				System.out.println(e.getSource().toString());
				System.out.println("===================================");
			}
		}
	}


		// This class will help track the key strokes on the keyboard
	public class ListenForKeys implements KeyListener
	{
			// Handles java's keyPressed events
		public void keyPressed(KeyEvent e)
		{
				// Add this to textArea
			textArea1.append("Key Hit: " + e.getKeyChar() + "\n");

				// print out some information within the console about
				// the keyPressed source information in string format
			System.out.println("===================================");
			System.out.println(e.getSource().toString());
			System.out.println("===================================");
		}

		public void keyTyped(KeyEvent e){}

		public void keyReleased(KeyEvent e){}

	}

		// MouseListener will track the movement of the mouse
	public class ListenForMouse implements MouseListener
	{
			//	Called once the mouse is clicked
		public void mouseClicked(MouseEvent e)
		{
			textArea1.append("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");
			textArea1.append("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
			textArea1.append("Mouse Button: " + e.getButton() + "\n");
			textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");

		}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e)
			{
					// Will print in text area once mouse is pressed
				textArea1.append("Mouse Event ");
			}

				// Will print the remainder of the statement from the pressed
			public void mouseReleased(MouseEvent e)
			{
				textArea1.append("Activated.\n");
			}
	}


	public class ListenForWindow implements WindowListener
	{
			//
		public void windowActivated(WindowEvent e)
		{
			textArea1.append("Window is Active.\n");
		}

		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		public void windowDeactivated(WindowEvent e) {
			textArea1.append("Window is Not Active.\n");

		}

		public void windowDeiconified(WindowEvent e) {
			textArea1.append("Window is Reinstated.\n");

		}

		public void windowIconified(WindowEvent e) {
			textArea1.append("Window is Minimized.\n");

		}

		public void windowOpened(WindowEvent e) {
			textArea1.append("Window is Opened.\n");

		}
	}
}
