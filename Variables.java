import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

public interface Variables {
	Font font = new Font("Times New Roman", Font.BOLD, 16);
	
	Object[] addedVariables = new Object[20];
	
	// Variables used to store data on tabs
	ArrayList<JPanel> buttonPanels = new ArrayList<>();
	ArrayList<JPanel> panelPanels = new ArrayList<>();
	ArrayList<JPanel> checkBoxPanels = new ArrayList<>();

	
	// Logic variables
	ArrayList<JButton> buttonsList = new ArrayList<>();
	ArrayList<JPanel> panelList = new ArrayList<>();
	ArrayList<JCheckBox> checkBoxList = new ArrayList<>();
	
	// Variables for Buttons  (Used to gather and store information)
	Object[][] buttonFeatures = new Object[100][4];
	JTextField name = new JTextField(20);
	JSlider buttonSizeX = new JSlider(0, 1920, 500);
	JSlider buttonSizeY = new JSlider(0, 1080, 500);

}