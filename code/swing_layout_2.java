import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public class Tutorial29 extends JFrame
{
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPlus, bMinus, clearAll;

	JTextField textResult;

	int num1, num2;

	public static void main(String[] args)
	{
		new Tutorial29();
	}

	public Tutorial29()
	{
			// Define the size of the JFrame
		this.setSize(400, 400);

			// Opens the JFrame in the middle of the screen
		this.setLocationRelativeTo(null);

			// Define the exit criteria for the JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set the title
		this.setTitle("Calculator");

			// Create the panel
		JPanel panel = new JPanel();

		/*
			// Create the grid layout
			// (asManyRowsAsNeeded = 0, columns, horz gap, vert gap)
		panel.setLayout(new GridLayout(0, 3, 2, 2));

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		clearAll = new JButton("Clear All");

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b0);
		panel.add(bPlus);
		panel.add(bMinus);
		panel.add(clearAll);

		*/

		panel.setLayout(new GridBagLayout());

		GridBagConstraints gridC = new GridBagConstraints();

		gridC.gridx = 1;

		gridC.gridy = 1;

		gridC.gridwidth = 1;

		gridC.gridheight = 1;

		gridC.weightx = 50;

		gridC.weighty = 100;

		gridC.insets = new Insets(5,5,5,5);

		gridC.anchor = GridBagConstraints.CENTER;

		gridC.fill = GridBagConstraints.BOTH;

		textResult = new JTextField("0", 20);

		Font font = new Font("Helvetica", Font.PLAIN, 18);

		textResult.setFont(font);

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		clearAll = new JButton("Clear All");

		panel.add(clearAll, gridC);
		gridC.gridwidth = 20;
		gridC.gridx = 5;
		panel.add(textResult, gridC);
		gridC.gridwidth = 1;
		gridC.gridx = 1;
		gridC.gridy = 2;

		panel.add(b1, gridC);
		gridC.gridx = 5;
		panel.add(b2, gridC);
		gridC.gridx = 9;
		panel.add(b3, gridC);
		gridC.gridx = 1;
		gridC.gridy = 3;
		panel.add(b4, gridC);
		gridC.gridx = 5;
		panel.add(b5, gridC);
		gridC.gridx = 9;
		panel.add(b6, gridC);
		gridC.gridx = 1;
		gridC.gridy = 4;
		panel.add(b7, gridC);
		gridC.gridx = 5;
		panel.add(b8, gridC);
		gridC.gridx = 9;
		panel.add(b9, gridC);
		gridC.gridx = 1;
		gridC.gridy = 5;
		panel.add(b0, gridC);
		gridC.gridx = 5;
		panel.add(bPlus, gridC);
		gridC.gridx = 9;
		panel.add(bMinus, gridC);


		this.add(panel);

		this.setVisible(true);
	}

}
