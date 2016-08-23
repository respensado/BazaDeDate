package md.convertit.bazaDeClienti.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import md.convertit.bazaDeClienti.services.FileService;

public class ClientTableFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel clPanel;
	private JTextField clientNameTextField;
	private JTextField emailTextField;
	private JTextField kidsTextField;
	private JTextField phoneTextField;
	private JTextField addressTextField;
	private JButton saveButton;
	private JButton deleteButton;
	private JButton editButton;
	private JTable table;
	private FileService fService;
	
	public ClientTableFrame() throws HeadlessException {
		super();
		setTitle("User Manager");
		setSize(800, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clPanel = new JPanel(new BorderLayout());
		getContentPane().add(clPanel);

		setMinimumSize(new Dimension(800, 300));
	}

	public void start() {
		
		addTopPanel();
		
		
		setVisible(true);
		
	}
	
	private void addTopPanel() {
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(25);
		panel.setBorder(new EtchedBorder());
		panel.setLayout(layout);
		
	}

	private void addCenterPanel() {

		ClientTableFrame cTableFrame = new ClientTableFrame();
		//table = new JTable(cTableFrame);
		
		

	}
}
