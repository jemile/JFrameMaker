import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

// This class will be for displaying the sliders and buttons to customize the JFrame
public class Frame extends JFrame
{
	private int width = 500;
	private int height = 600;
	private Font font = new Font("Times New Roman", Font.BOLD, 16);

	
	/*
	 This is my first kind of big project so I am thinking of a lot but button will have the option to be added to already made panel if not already, and loop
	 to get each panel and option
	 */
	
	// Variables used to store data
	private ArrayList<String> addedItems = new ArrayList<>();
	private String[] frameItems = {"Button", "Panel", "Checkbox"};
	private int panelHeight = 100;
	// String used to get what item of menuBar is currently selected
	private String selectedItem;
	
	// Menu features
	private JComboBox<String> menuBar;
	private JPanel panel;
	private JButton addItem;
	private JLabel menuText;
	private JTextField menuName;
	
	// Customization for Button
	private JLabel text;
	private JTextField name;
	
	// Method used to display different features based on the frameItem selected
	public void displayFeatures()
	{
		selectedItem = (String)menuBar.getSelectedItem();
		if (selectedItem.equals("Button"))
		{
			panel.removeAll();
		
			// Feature to add Button name and Text
			text = new JLabel();
			text.setLayout(null);
			text.setBounds(10, 45, 50, 5);
			text.setText("Button Name: ");
			text.setFont(font);
			
			name = new JTextField(20);
			name.setLayout(null);
			name.setBounds(60, 45, 470, 5);
			name.setFont(font);
			
			panel.add(text);
			panel.add(name);
			panel.revalidate();
			panel.repaint();
		}
		if (selectedItem.equals("Panel"))
		{
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
		}
		if (selectedItem.equals("Checkbox))"))
		{
			panel.removeAll();			
			panel.revalidate();
			panel.repaint();
		}
		panel.setBounds(10, 40, 470, panelHeight);

	}
	
	// Method to get all the information inside the given customization
	public void addItem()
	{
		addedItems.add(selectedItem);
		Object chosen = menuBar.getSelectedItem();
		
		if (chosen instanceof JButton)
		{
			Objects obj = new Objects();
		}
		
	}
	
	public void removeItem()
	{
		addedItems.remove(selectedItem);
	}
	
	// Constructor
	Frame()
	{
		// Customization menu
		this.setFont(font);
		this.setTitle("JFrameAutomater: Customization");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setSize(width, height);
		this.setFont(font);
		this.getContentPane().setBackground(new Color(53, 137, 189));
		
		menuBar = new JComboBox<>(frameItems);
		menuBar.setBounds(10, 10, 470, 20);
		menuBar.setBackground(new Color(53, 137, 189));
		menuBar.setVisible(true);
		menuBar.setFont(font);
		menuBar.addActionListener(e -> displayFeatures());
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 167, 227));
		panel.setVisible(true);
		
		// Display menu bar so user doesn't get confused, and code works
		displayFeatures();
		
		addItem = new JButton();
		addItem.setText("Add Item");
		addItem.addActionListener(e -> addItem());
		addItem.setBounds(10, panelHeight + 50, 470, 20);
		
		menuText = new JLabel();
		menuText.setBounds(10, panelHeight + 80, 120, 20);
		menuText.setFont(font);
		menuText.setText("Menu Title: ");
		
		menuName = new JTextField();
		menuName.setBounds(90, panelHeight + 80, 380, 20);
		menuName.setFont(font);
		
		this.add(menuBar);
		this.add(panel);
		this.add(addItem);
		this.add(menuName);
		this.add(menuText);
		
		
	}
	
	
	
}