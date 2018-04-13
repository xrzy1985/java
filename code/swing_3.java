import javax.swing.*;

import java.awt.event.*;

import javax.swing.event.ChangeEvent;

import javax.swing.event.ChangeListener;

import java.text.NumberFormat;

import javax.swing.border.*;

@SuppressWarnings({ "serial" })
public class Tutorial22 extends JFrame
{
	JButton button1;
	JLabel label1, label2, label3;
	JTextField textField1, textField2;
	JCheckBox dollarSign, commaSeparator;
	JRadioButton addNumbers, subNumbers, multiNumbers, divNumbers;
	JSlider howManyTimes;

	double number1, number2, total;

	public static void main(String[] args)
	{
		new Tutorial22();
	}


	public Tutorial22()
	{

			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Third Frame Tutorial");

			// Create the JPanel object that will contains the components
			// of the panel; button, jtextfield, etc
		JPanel panel = new JPanel();

			// Create the button
		button1 = new JButton("Calulate");

			// Create the instance of ListenForEvents
		ListenForButton lforButton = new ListenForButton();

			// The next part will alert the user when an
			// event has occurred that includes the button
		button1.addActionListener(lforButton);

			// Make sure to add the button
		panel.add(button1);

			// Create a label for the first number
		label1 = new JLabel("Number 1: ");

			// Add the label to the panel
		panel.add(label1);

			// Create a text field for the user to enter the number
		textField1 = new JTextField("", 5);

			// add the text field to the panel
		panel.add(textField1);

			// Create another label for number 2
		label2 = new JLabel("Number 2: ");

			// must add the label to the panel
		panel.add(label2);

			// Create another empty place for the user to enter a number
		textField2 = new JTextField("", 5);

			// add the text field or it wont show up
		panel.add(textField2);

			// instantiate the JCheckbox object: dollarSigns
		dollarSign = new JCheckBox("Dollars");

			// instantiate the JCheckbox object: commas
		commaSeparator = new JCheckBox("Commas");

			// make sure to add dollar sign and comma separator
		panel.add(dollarSign);

				// true means checked by default
		panel.add(commaSeparator, true);

			// Instantiate JRadio button objects
		addNumbers = new JRadioButton("Add");
		subNumbers = new JRadioButton("Subtract");
		multiNumbers = new JRadioButton("Multiply");
		divNumbers = new JRadioButton("Divide");

			// Group the buttons together in a ButtonGroup object
		ButtonGroup operation = new ButtonGroup();

			// Add each individual radio button to the ButtonGroup object created
		operation.add(addNumbers);
		operation.add(subNumbers);
		operation.add(multiNumbers);
		operation.add(divNumbers);

			// Create another panel for the JButtons
		JPanel operationPanel = new JPanel();

			// additional panel was required to add the border to the radio buttons
			// the border will help users distinguish between the separate entities
			// create a Border object
		Border operationBorder = BorderFactory.createTitledBorder("Operations");

			// add border to the operationPanel created early for the radio buttons
		operationPanel.setBorder(operationBorder);

			// Adds the radio buttons to the operationPanel created for the radio buttons
		operationPanel.add(addNumbers);
		operationPanel.add(subNumbers);
		operationPanel.add(multiNumbers);
		operationPanel.add(divNumbers);

			// this will ensure that addNumbers is selected upon execution
		addNumbers.setSelected(true);

			// add our additional panel to our first existing panel
		panel.add(operationPanel);

			// Instantiate the label for our slider object
		label3 = new JLabel("Perform How Many Times");

			// add the label to the panel
		panel.add(label3);

			// Instantiate the JSlider object with a min of 0
			// a max of 100, and the initial value being 1
		howManyTimes = new JSlider(0, 100, 1);

			// minimum spacing between ticks
		howManyTimes.setMinorTickSpacing(1);

			// maximum spacing between ticks
		howManyTimes.setMajorTickSpacing(10);

			// Draws the tick labels on the slider
		howManyTimes.setPaintLabels(true);

			// Draws the ticks on the slider
		howManyTimes.setPaintTicks(true);

			// create an instance of ListenForSlider
		ListenForSlider lforSlider = new ListenForSlider();

			// This must be added in order for java to alert the user
			// to a change in the slider
		howManyTimes.addChangeListener(lforSlider);

			// add the slider object to the panel
		panel.add(howManyTimes);

			// Add the panel to the currently created object
		this.add(panel);

			// Set the JFrame to visible
		this.setVisible(true);

			// Gives the focus to the text field
		textField1.requestFocus();
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
						// getText will return a string
						// parseDouble is used to parse the data into a double
					number1 = Double.parseDouble(textField1.getText());
					number2 = Double.parseDouble(textField2.getText());
				}
				catch(NumberFormatException excep)
				{
						// Will display an error message and stop execution
					JOptionPane.showMessageDialog(Tutorial22.this, "Please enter the right information", "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}


					// The following is a group of if statements that will
					// either add, subtract, multipl, or divide the two
					// user entered numbers in the text fields.

				if(addNumbers.isSelected())
				{
					total = addNumbers(number1, number2, howManyTimes.getValue());
				}
				else if(subNumbers.isSelected())
				{
					total = subtractNumbers(number1, number2, howManyTimes.getValue());
				}
				else if (multiNumbers.isSelected())
				{
					total = multiplyNumbers(number1, number2, howManyTimes.getValue());
				}
				else
				{
					total = divideNumbers(number1, number2, howManyTimes.getValue());
				}


				if(dollarSign.isSelected())
				{
					NumberFormat numFormat = NumberFormat.getCurrencyInstance();

					JOptionPane.showMessageDialog(Tutorial22.this, numFormat.format(total), "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				else if (commaSeparator.isSelected())
				{
					NumberFormat numFormat = NumberFormat.getNumberInstance();

					JOptionPane.showMessageDialog(Tutorial22.this, numFormat.format(total), "Solution", JOptionPane.INFORMATION_MESSAGE);
				}

				else
				{
					JOptionPane.showMessageDialog(Tutorial22.this, total, "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	private class ListenForSlider implements ChangeListener
	{

		@Override
		public void stateChanged(ChangeEvent e)
		{
				// Checks to see if the source of the event was the slider
			if(e.getSource() == howManyTimes)
			{
				label3.setText("Perform how many times? " + howManyTimes.getValue());
			}
		}

	}


	public static double addNumbers(double number1, double number2, int howMany)
	{
		double totall = 0;

		int i = 1;

		while(i <= howMany)
		{
			totall = totall + (number1 + number2);
			i++;
		}

		return totall;
	}

	public static double subtractNumbers(double number1, double number2, int howMany)
	{
		double totall = 0;

		int i = 1;

		while(i <= howMany)
		{
			totall = totall + (number1 - number2);
			i++;
		}

		return totall;
	}

	public static double multiplyNumbers(double number1, double number2, int howMany)
	{
		double totall = 0;

		int i = 1;

		while(i <= howMany)
		{
			totall = totall + (number1 * number2);
			i++;
		}

		return totall;
	}

	public static double divideNumbers(double number1, double number2, int howMany)
	{
		double totall = 0;

		int i = 1;

		while(i <= howMany)
		{
			try
			{
				totall = totall + (number1 / number2);
				i++;
			}
			catch (ArithmeticException e)
			{
				System.out.println("You cannot divide by zero");
				System.out.println(e.getMessage());
				System.out.println(e.toString());
				e.printStackTrace();
			}
		}

		return totall;
	}

}
