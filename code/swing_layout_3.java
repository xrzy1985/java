import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Tutorial30 extends JFrame
{
	JLabel nameLabel, streetLabel, stateLabel, dateLabel,
		ageLabel, sexLabel, optionsLabel, aboutLabel;
	JTextField nameText, streetText;
	JComboBox stateList;
	JSpinner dateSpin;
	JSlider ageSlider;
	JRadioButton maleRadio, femaleRadio;
	ButtonGroup sexGroup;
	JCheckBox morningCheck, afternoonCheck, eveningCheck;
	JTextArea aboutYou;

	public static void main(String[] args)
	{
			// Call the constructor
		new Tutorial30();
	}

	public Tutorial30()
	{
			// Define the size of the JFrame
		this.setSize(800, 800);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Random Layout");

			// Create the panel
		JPanel panel = new JPanel();

			// set the panel layout
		panel.setLayout(new GridBagLayout());

			// initialize the nameLabel
		nameLabel = new JLabel("   Name: ");

			// This is a private method created below
			// takes in the
			// (panel, component, x position, y position, component width, component height, layout place, layout stretch)
			// Add the nameLabel to the panel
		addComponent(panel, nameLabel, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

			// Create a textField with 30 characters
		nameText = new JTextField(30);

			// Add the nameText to the panel using the created method
		addComponent(panel, nameText, 1, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

			// Street label
		streetLabel = new JLabel("   Street: ");

			// add the street label to the panel
		addComponent(panel, streetLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

			// Create a text field for the stree text
		streetText = new JTextField(30);

			// Add streetText to the panel
		addComponent(panel, streetText, 1, 1, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

			// Check boxes are best if they are grouped
			// Create a sexBox Box (vertical)
		Box sexBox = Box.createVerticalBox();

			// Create male and female radio buttons
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");

			// initialize the ButtonGroup
		sexGroup = new ButtonGroup();

			// Add the male and female buttons to the sexGroup
		sexGroup.add(maleRadio);
		sexGroup.add(femaleRadio);

			// Add the radio buttons to the sexBox
		sexBox.add(maleRadio);
		sexBox.add(femaleRadio);

			// set the box with a border
		sexBox.setBorder(BorderFactory.createTitledBorder("Sex"));

			// add the box to the panel
		addComponent(panel, sexBox, 3, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

			// Create a separate panel for the states
		JPanel statePanel = new JPanel();

			// Using the flowLayout for the state panel
		statePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

		stateLabel = new JLabel("State");

		statePanel.add(stateLabel);

			// Create array to hold the states
		String[] states = {"Ga", "Tn", "Mi", "Il"};

			// add the states array to the combo box
		stateList = new JComboBox(states);

			// add the combo box to the actual states panel
		statePanel.add(stateList);

		dateLabel = new JLabel("Appointment Date");

		statePanel.add(dateLabel);

			// Create a Date object
		Date todaysDate = new Date();

			// instantiate the spinner object
			// (default date, minimum, maximum, and how the spinner will increment)
		dateSpin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));

			// DateEditor handles the displaying and editing of dates
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpin, "dd/mm/yy");

			// set the editor for dateSpin object
		dateSpin.setEditor(dateEditor);

			// add the spinner to the states panel
		statePanel.add(dateSpin);

			// instantiate the age label
		ageLabel = new JLabel("Age: 50");

			// add the age label to the state panel
		statePanel.add(ageLabel);

			// instantiate the jslider
			// (minimumValue, maximumValue, startingValue)
		ageSlider = new JSlider(1, 100, 50);

			// Create a ListenForSlider object
			// we will create the method below like in the previous tutorials
		ListenForSlider lforSlider = new ListenForSlider();

			// add the changeListener to the slider
		ageSlider.addChangeListener(lforSlider);

			// add the slider to the states panel
		statePanel.add(ageSlider);

			// add the statePanel components to the original panel
		addComponent(panel, statePanel, 1, 2, 5, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

			// initialize the check boxes
		morningCheck = new JCheckBox("Morning");
		afternoonCheck = new JCheckBox("Afternoon");
		eveningCheck = new JCheckBox("Evening");

			// create a box for the check boxes
		Box optionBox = Box.createVerticalBox();

			// add the check boxes to the Box
		optionBox.add(morningCheck);
		optionBox.add(afternoonCheck);
		optionBox.add(eveningCheck);

			// Add a border to the box
		optionBox.setBorder(BorderFactory.createTitledBorder("Time of Day"));

			// add the Box to the panel
		addComponent(panel, optionBox, 1, 3, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);


		aboutYou = new JTextArea(6, 40);
		aboutYou.setText("Tell us something about yourself, mate");

			// If text will not fit on a line, jump to a new line
		aboutYou.setLineWrap(true);

			// Ensure the words will not separate in the middle if
			// a new line situation occurs
		aboutYou.setWrapStyleWord(true);;

			// Add a scrollbar to the textArea
		JScrollPane scrollBar1 = new JScrollPane(aboutYou, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		addComponent(panel, scrollBar1, 2, 3, 3, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

			// This will add the panel to the current object
		this.add(panel);

			// this will adjust the size of the jframe to best fit the components
		this.pack();

			// Allow the user to resize the window (true) , or not (false)
		this.setResizable(false);

			// This must be true in order for the jframe to be seen
		this.setVisible(true);
	}


		// private methode addComponent will handle components for the grid bag layout
		// This can be tedious work, which is why a method should be created
		// The idea is to work smart, not hard
		// Be as abstract as possible, I'm not very abstract with my tutorials
		// But I try to cover and comment as much as possible

	private void addComponent(JPanel panel, JComponent component, int xPos, int yPos, int componentWidth, int componentHeight, int place, int strectch)
	{
		GridBagConstraints gCon = new GridBagConstraints();

		gCon.gridx = xPos;
		gCon.gridy = yPos;
		gCon.gridwidth = componentWidth;
		gCon.gridheight = componentHeight;
		gCon.weightx = 100;
		gCon.weighty = 100;
		gCon.insets = new Insets(5,5,5,5);
		gCon.anchor = place;
		gCon.fill = strectch;

		panel.add(component, gCon);

	}

		// The method is called once the slider has been moved
		// It will modify the age on the label from the initial value of 50
		// to whatever it needs to be set at

	private class ListenForSlider implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			if(e.getSource() == ageSlider)
			{
				ageLabel.setText("AGE: " + ageSlider.getValue());
			}
		}

	}
}
