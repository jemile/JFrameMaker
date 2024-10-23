import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import javax.swing.BoxLayout;
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
		buttonFeatures[buttonIter][1] = buttonSizeX.getValue();
		buttonFeatures[buttonIter][2] = buttonSizeY.getValue();

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
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setBackground(new Color(84, 155, 222));
				panel.setBorder(null);
				
				// Button Name
				JLabel label = new JLabel();
				
				// Sometimes the conversion to data doesn't work so this is a fail case incase
				// The person puts a panel or checkBox before, I'll find a more permanent fix in the future.
				if ((String) buttonFeatures[i][0] == null)
				{
					buttonFeatures[i][0] = name.getText();
				}
			
				String copy = (String) buttonFeatures[i][0];
				String text = "Button Name: " + copy;
				
				label.setText(text);
				label.setFont(font);
				label.setAlignmentX(Component.CENTER_ALIGNMENT);

				// Button X and Y
				JLabel buttonSizeXLabel = new JLabel();
				JLabel buttonSizeYLabel = new JLabel();
				
				if ((Integer) buttonFeatures[i][1] == null || (Integer) buttonFeatures[i][2] == null)
				{
					buttonFeatures[buttonIter][1] = buttonSizeX.getValue();
					buttonFeatures[buttonIter][2] = buttonSizeY.getValue();
				}
				
				buttonSizeXLabel.setFont(font);
				buttonSizeYLabel.setFont(font);
				
				String buttonSizeXText = "Button Starting Pos X: " + (int) buttonFeatures[i][1];
				String buttonSizeYText = "Button Starting Pos Y: " + (int) buttonFeatures[i][2];

				buttonSizeXLabel.setText(buttonSizeXText);
				buttonSizeYLabel.setText(buttonSizeYText);
				
				buttonSizeXLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				buttonSizeYLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

				panel.add(label);
				panel.add(buttonSizeXLabel);
				panel.add(buttonSizeYLabel);
				
				buttonPanels.add(panel);
				
				tabbedPane.addTab("Button: " + i, panel);
			}
			
			if (addedVariables[i] instanceof JPanel)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panelPanels.add(panel);
				tabbedPane.addTab("Panel: " + i, panel);
			}
			
			if (addedVariables[i] instanceof JCheckBox)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
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