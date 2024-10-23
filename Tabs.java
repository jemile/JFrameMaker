import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Tabs implements Variables
{
	// Index of how many tabs there are
	private int buttonIter;
	private int panelIter;
	private int checkBoxIter;
	
	// GUI Features
	JTabbedPane tabbedPane = new JTabbedPane();
	
	/*
	 Zero will be button name for buttons
	 0 will be x starting pos
	 1 will be y starting pos
	 2 will be x length
	 3 will be y length
	 4 will be gathered from a color picker
	 5 will be 
	 */
	public void addButton(JButton type)
	{
		// Store all the information from the Button
		buttonFeatures[buttonIter][0] = name.getText();

		// Add it to global list
		addedVariables[buttonIter + panelIter + checkBoxIter] = type;
		
		// Add the Button to the list
        buttonsList.add(type);
        buttonIter++;
	    
	}
	
	public void addPanel(JPanel type)
	{
		// Add it to global list
		addedVariables[buttonIter + panelIter + checkBoxIter] = type;
		
		panelIter++;
		panelList.add(type);
	}
	
	public void addCheckBox(JCheckBox type)
	{
		// Add it to global list
		addedVariables[buttonIter + panelIter + checkBoxIter] = type;
		
		checkBoxIter++;
		checkBoxList.add(type);
	}
	
	// Method to render the new tab and show the different options you chose, will be where you remove them also
	public void renderTab()
	{
		tabbedPane.removeAll();
		
		JFrame frame = new JFrame("JFrameAutomater: Widgets");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(53, 137, 189));
					
		for (int i = 0; i < addedVariables.length; i++)
		{
			if (addedVariables[i] instanceof JButton)
			{
				// JTabbedPane use panels to store what is on it
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				JLabel label = new JLabel();
				// Need to find a way to get the information the user put in
				String copy = (String) buttonFeatures[i][0];
				if (copy == null)
				{
					copy = "(Unnamed)";
				}
				String text = "Button Name: " + copy;
				label.setText(text);
				panel.add(label);
				buttonPanels.add(panel);
				
				tabbedPane.addTab("Button: " + i, panel);
			}
			
			if (addedVariables[i] instanceof JPanel)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				panelPanels.add(panel);
				tabbedPane.addTab("Panel: " + i, panel);
			}
			
			if (addedVariables[i] instanceof JCheckBox)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout());
				checkBoxPanels.add(panel);
				tabbedPane.addTab("CheckBox: " + i, panel);
			}
		}
		
		frame.add(tabbedPane);
	}
	
	public int getLength()
	{
		return buttonIter + panelIter + checkBoxIter;
	}
	

}