import javax.swing.*;

import java.awt.event.*;

import java.text.NumberFormat;

public class Tutorial24 extends JFrame
{
	JComboBox favoriteLanguages;
	JButton button1;
	String infoOnComponent = "";

	public static void main(String[] args)
	{
		new Tutorial24();
	}

	public Tutorial24()
	{

			// Define the size of the JFrame
		this.setSize(400, 200);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Fourth Frame Tutorial");

			// Create the JPanel object that will contains the components
			// of the panel; button, jtextfield, etc
		JPanel panel = new JPanel();

			// To use a combo box, you must utilize a data storage type
			// A string array will work out well
		String[] languages = {"Java", "Python", "C++"};

			// Add the string array to the combo box
		favoriteLanguages = new JComboBox(languages);

			// Add a language
		favoriteLanguages.addItem("C#");

			// add the jcombobox to the panel
		panel.add(favoriteLanguages);

			// create a button
		button1 = new JButton("Get the Answer");

			// create instance of the ListenForButton class
		ListenForButton lforButton = new ListenForButton();

			// add Action listener to the button
		button1.addActionListener(lforButton);

			// Don't forget to add the button to the panel
		panel.add(button1);

			// To insert an item at a specific spot
		favoriteLanguages.insertItemAt("Javascript", 2);

			// if you want to limit how many items show at a time
		favoriteLanguages.setMaximumRowCount(4);

		/*
		 * To remove items
		 * 		favoriteLanguages.removeItem("Javascript");
		 *
		 * 	Remove an item at a specific location
		 * 		favoriteShows.removeItemAt(1);
		 *
		 * 	remove all items
		 * 		favoriteLanguages.removeAllItems();
		 */

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
					favoriteLanguages.setEditable(true);

						// get the item at 0
					infoOnComponent += "Item at 0: " + favoriteLanguages.getItemAt(0) + "\n";

						// get the number of items in the combo box
					infoOnComponent += "Number of Languages: " + favoriteLanguages.getItemCount() + "\n";

						// Get the index of selected item
					infoOnComponent += "Selected ID: " + favoriteLanguages.getSelectedIndex() + "\n";

						// Get the value for the selected item
					infoOnComponent += "Selected Languages: " + favoriteLanguages.getSelectedItem() + "\n";

						// To find out if the combo box items are editable
					infoOnComponent += "CombBox Editable: " + favoriteLanguages.isEditable() + "\n";

					JOptionPane.showMessageDialog(Tutorial24.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);

					infoOnComponent = "";
				}
				catch(NumberFormatException excep)
				{

				}
			}
		}
	}

}
