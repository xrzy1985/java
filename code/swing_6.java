import javax.swing.*;

import java.awt.event.*;

	// Store different heights and widths
import java.awt.Dimension;

	// Dates
import java.util.Date;

	//
import javax.swing.SpinnerDateModel;

	// Calender which makes dates easy
import java.util.Calendar;


@SuppressWarnings("serial")
public class Tutorial26 extends JFrame
{
	JButton button1;
	JSpinner spinner1, spinner2, spinner3, spinner4;
	String outputString = "";

	public static void main(String[] args)
	{
		new Tutorial26();
	}

	public Tutorial26()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Sixth Frame Tutorial");

			// Create the JPanel object that will contains the components
			// of the panel; button, jtextfield, etc
		JPanel panel = new JPanel();

			// create a button
		button1 = new JButton("Get the Answer");

			// create instance of the ListenForButton class
			// It executes the ListenForButton method that must be defined
		ListenForButton lforButton = new ListenForButton();

			// add Action listener to the button
		button1.addActionListener(lforButton);

			// Don't forget to add the button to the panel
		panel.add(button1);

			// The default spinner allows incrementing through digits 1-9
		spinner1 = new JSpinner();

			// add the spinner to panel
		panel.add(spinner1);

			// more advanced spinner
			// initial number, starting number, max number, increment by number
		spinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

			//
		panel.add(spinner2);

			// create array to store values
		String[] weekDays = {"Mon", "Tues", "Weds", "Thurs", "Friday"};

			// Create spinner with array data
		spinner3 = new JSpinner(new SpinnerListModel(weekDays));

			// create a Dimensions object to help set the size
			// of the spinners
		Dimension d1 = spinner1.getPreferredSize();

			// Sets the width in pixels for the specified spinner
		d1.width = 80;

			// sets the preferred size of the spinner to what we set
		spinner1.setPreferredSize(d1);

		Dimension d2 = spinner2.getPreferredSize();
		d2.width = 80;
		spinner2.setPreferredSize(d2);
		Dimension d3 = spinner3.getPreferredSize();
		d3.width = 80;
		spinner3.setPreferredSize(d3);
		panel.add(spinner3);

			// Date
		Date todaysDate = new Date();

			// initialize spinner4 with
			// (todaysDate, null, null, Calendar. and choose one that best fits you
		spinner4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));

			//This will help format the date for the user
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4,  "dd/mm/yyyy");

		spinner4.setEditor(dateEditor);

		panel.add(spinner4);

		Dimension d4 = spinner4.getPreferredSize();

		d4.width = 80;

		spinner4.setPreferredSize(d3);

		this.add(panel);

		this.setVisible(true);
	}

	private class ListenForButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
				// Check if the source of an event was the button
			if(e.getSource() == button1)
			{
				try
				{
					outputString += "Spinner1 Value: " + spinner1.getValue() + "\n";
					outputString += "Spinner2 Value: " + spinner2.getValue() + "\n";
					outputString += "Spinner3 Value: " + spinner3.getValue() + "\n";
					outputString += "Spinner4 Value: " + spinner4.getValue() + "\n";

					JOptionPane.showMessageDialog(Tutorial26.this,  outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
					outputString = "";
				}
				catch(NumberFormatException excep)
				{

				}
			}
		}
	}

}
