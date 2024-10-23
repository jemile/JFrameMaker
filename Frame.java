import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSeparator;

import java.awt.Color;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

// This class will be for displaying the sliders and buttons to customize the JFrame
public class Frame extends JFrame implements Variables
{
	private int width = 500;
	private int height = 600;
	private Font font = new Font("Times New Roman", Font.BOLD, 16);

	
	/*
	 This is my first kind of big project so I am thinking of a lot but button will have the option to be added to already made panel if not already, and loop
	 to get each panel and option
	 */
	
	// Variables used to store data
	private ArrayList<Tabs> addedItems = new ArrayList<>();
	private String[] frameItems = {"Button", "Panel", "Checkbox"};
	private int panelHeight = 200;
	// String used to get what item of menuBar is currently selected
	private String selectedItem;
	
	// Menu features
	private JComboBox<String> menuBar;
	private JPanel panel;
	private JButton addItem;
	private JButton previewItems;
	private JLabel menuText;
	private JTextField menuName;
	private Tabs obj = new Tabs();
	private JLabel xText;
	private JSlider menuSizeX;
	private JLabel yText;
	private JSlider menuSizeY;
	private JSeparator separator;

	// Customization for Button
	private JLabel text;
	
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
		if (selectedItem.equals("Checkbox"))
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
		if (selectedItem.equals("Button"))
		{
			obj.addButton(new JButton());
		}
		
		if (selectedItem.equals("Panel"))
		{
			obj.addPanel(new JPanel());
		}
		
		if (selectedItem.equals("Checkbox"))
		{
			obj.addCheckBox(new JCheckBox());
		}
		
		addedItems.add(obj);
		
	}
	
	// Method to open up another tab that previews the Objects you've created
	public void previewItems()
	{
		// Check to make sure an Object is already added by user
		if (obj != null && obj.getLength() > 0)
		{
			  obj.renderTab();
		}
	}
	
	public void updateSliderValue()
	{	
		String m_xText = "X Size: " + Integer.toString(menuSizeX.getValue());
		String m_yText = "Y Size: " + Integer.toString(menuSizeY.getValue());

		xText.setText(m_xText);
		yText.setText(m_yText);
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
		
		previewItems = new JButton();
		previewItems.setText("Preview Items");
		previewItems.addActionListener(e -> previewItems());
		previewItems.setBounds(10, panelHeight + 80, 470, 20);

		
		separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setBackground(new Color(97, 140, 201));
		separator.setBounds(0, panelHeight + 115, 500, 30);
		
		menuText = new JLabel();
		menuText.setBounds(10, panelHeight + 125, 120, 20);
		menuText.setFont(font);
		menuText.setText("Menu Title: ");
		
		menuName = new JTextField();
		menuName.setBounds(90, panelHeight + 125, 380, 20);
		menuName.setFont(font);
		
		xText = new JLabel();
		xText.setBounds(10, panelHeight + 150, 100, 20);
		xText.setFont(font);
		xText.setText("X Size: 500");
		
		menuSizeX = new JSlider(0, 1920, 500);
		menuSizeX.setBounds(120, panelHeight + 150, 340, 20);
		menuSizeX.setOpaque(false);
		menuSizeX.setBackground(new Color (0, 0, 0, 0));
		menuSizeX.addChangeListener(e -> updateSliderValue());

		yText = new JLabel();
		yText.setBounds(10, panelHeight + 180, 100, 20);
		yText.setFont(font);
		yText.setText("Y Size: 500");
		
		menuSizeY = new JSlider(0, 1080, 500);
		menuSizeY.setBounds(120, panelHeight + 180, 340, 20);
		menuSizeY.setOpaque(false);
		menuSizeY.setBackground(new Color (0, 0, 0, 0));
		menuSizeY.addChangeListener(e -> updateSliderValue());
		
		this.add(menuBar);
		this.add(panel);
		this.add(addItem);
		this.add(previewItems);
		
		this.add(separator);
		this.add(menuName);
		this.add(menuText);
		this.add(xText);
		this.add(yText);
		this.add(menuSizeX);
		this.add(menuSizeY);
	}
}