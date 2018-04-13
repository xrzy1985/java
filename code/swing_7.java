import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

import tutorial.tutorial_26.Tutorial26;

import java.util.Enumeration;

public class Tutorial27 extends JFrame
{

	JButton button1;
	String outputString = "";

		// A tree will contain nodes that can contain other nodes
	/*
	 * 			A
	 * 		/\		/\
	 * 		B C		D E
	 */

		// To create a JTree
	JTree theTree;

	DefaultMutableTreeNode documents, work, games, emails;

	DefaultMutableTreeNode fileSystem = new DefaultMutableTreeNode("C Drive");

	public static void main(String[] args)
	{
		new Tutorial27();
	}

	public Tutorial27()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Seventh Frame Tutorial");

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

			// Create the actual tree
		theTree = new JTree(fileSystem);

			// To ensure only one node is selected at a time
		theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

			//
		theTree.setVisibleRowCount(8);

			//
		documents = addAFile("Docs", fileSystem);

			//
		addAFile("Resume.docx", documents);

		addAFile("CoverLetter.docx", documents);

		emails = addAFile("Emails", documents);

		addAFile("Schedule.txt", documents);

		addAFile("CallJames.txt", emails);

		work = addAFile("Work Applications", fileSystem);

		addAFile("Spreadsheet.exe", work);

		addAFile("WordProcessor.exe", work);

		games = addAFile("Games", fileSystem);

		addAFile("GTA V", games);

		addAFile("Halo 5", games);

		JScrollPane scrollBox = new JScrollPane(theTree);

		Dimension d = scrollBox.getPreferredSize();

		d.width = 200;

		scrollBox.setPreferredSize(d);

		panel.add(scrollBox);

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
					Object treeObject = theTree.getLastSelectedPathComponent();

					DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) treeObject;

					String treeNode = (String) theFile.getUserObject();

					outputString += "The Selected Node: " + treeNode + "\n";

					outputString += "Number of Children: " + theFile.getChildCount() + "\n";

					outputString += "Number of Siblings: " + theFile.getSiblingCount() + "\n";

					outputString += "The Parent: " + theFile.getParent() + "\n";

					outputString += "Next Node: " + theFile.getNextNode() + "\n";

					outputString += "Previous Node: " + theFile.getPreviousNode() + "\n";

					outputString += "\nChildren of Node\n";

					for(Enumeration enumValue = theFile.children(); enumValue.hasMoreElements();)
					{
						outputString += enumValue.nextElement() + "\n";
					}

					outputString += "\nPath from Root\n";

					TreeNode[] pathNodes = theFile.getPath();

					for(TreeNode individualNodes: pathNodes)
					{
						outputString += individualNodes + "\n";
					}

					JOptionPane.showMessageDialog(Tutorial27.this,  outputString, "Information", JOptionPane.INFORMATION_MESSAGE);

					outputString = "";

				}
				catch(NumberFormatException excep)
				{

				}
			}
		}
	}

	private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder)
	{
		DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
		parentFolder.add(newFile);

		return newFile;

	}

}
