import javax.swing.*;

import java.awt.event.*;

public class Tutorial25 extends JFrame
{
	JList favoriteMovies, favoriteColors;
	DefaultListModel defaultListModel = new DefaultListModel();
	JScrollPane scroller;
	JButton button1;
	String infoOnComponent = "";

	public static void main(String[] args)
	{
			// Call the constructor inside the main function
		new Tutorial25();
	}

	public Tutorial25()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Fifth Frame Tutorial");

			// Create the JPanel object that will contains the components
			// of the panel; button, jtextfield, etc
		JPanel panel = new JPanel();

			// create a button
		button1 = new JButton("Get the Answer");

			// create instance of the ListenForButton class
		ListenForButton lforButton = new ListenForButton();

			// add Action listener to the button
		button1.addActionListener(lforButton);

			// Don't forget to add the button to the panel
		panel.add(button1);

			// array of strings
		String[] movies = {"The Matrix", "Troy", "IT"};

		favoriteMovies = new JList(movies);

		favoriteMovies.setFixedCellHeight(30);

		favoriteMovies.setFixedCellWidth(150);

		// Define how many selections can be made
		// MULTIPLE_INTERVAL_SELECTION: Select what ever you want
		// SINGLE_SELECTION: Select only one
		// SINGLE_INTERVAL_SELECTION: Select as many as you want if in order

		favoriteMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		// All the methods for lists
		/*
		* getSelectedIndex(): returns the index for the first selected item
		* getSelectedIndexes(): returns every selection in a list
		* getSelectedValue(): returns the value of the first selected
		* getSelectedValues(): returns an array of all values
		* isSelectedIndex(): returns true if index is selected
		*/

			// Default list model
		String[] colors = {"BLACK", "BLUE", "RED", "GREEN", "YELLOW"};

			// load colors into list
		for(String color: colors)
		{
			defaultListModel.addElement(color);
		}

			// Add a item to the list
		defaultListModel.add(2, "ORANGE");

			//
		favoriteColors = new JList(defaultListModel);

			// ensure you can only see 4 items
		favoriteColors.setVisibleRowCount(4);

			// call scroller
		scroller = new JScrollPane(favoriteColors,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		favoriteColors.setFixedCellHeight(30);
		favoriteColors.setFixedCellWidth(150);

		panel.add(favoriteMovies);

		panel.add(scroller);

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
					if(defaultListModel.contains("BLACK"))
					{
						infoOnComponent += "Black is here\n";
					}
					if(!defaultListModel.isEmpty())
					{
						infoOnComponent += "Isn't empty\n";
					}

					infoOnComponent += "Elements in the list " + defaultListModel.size() + "\n";

					infoOnComponent += "Last Element " + defaultListModel.firstElement() + "\n";

					infoOnComponent += "Last Element " + defaultListModel.lastElement() + "\n";

					infoOnComponent += "Element in index 1 " + defaultListModel.get(1) + "\n";

						// Remove element by name
					defaultListModel.removeElement("BLACK");

						// Remove item at 0
					defaultListModel.remove(0);

						// Create array with all of the list elements
					Object[] arrayOfList = defaultListModel.toArray();

						// populate the array with the list
					for(Object color: arrayOfList)
					{
						infoOnComponent += color + "\n";
					}

					JOptionPane.showMessageDialog(Tutorial25.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);

					infoOnComponent = "";
				}
				catch(NumberFormatException excep)
				{

				}
			}
		}
	}

}
