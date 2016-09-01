package md.convertit.bazaDeClienti.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel mainPanel;
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
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.gray);
		getContentPane().add(mainPanel);

		setMinimumSize(new Dimension(800, 300));
	}

	public void start() {

	addTopPanel();
	addBottomPanel();
	addLeftPanel();
	addRightPanel();

		setVisible(true);

	}

	private void addRightPanel() {
		JPanel rPanel = new JPanel();
		
		rPanel.setBackground(Color.yellow);

		mainPanel.add(rPanel,BorderLayout.EAST);
		
	}

	private void addLeftPanel() {
		JPanel lPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(lPanel, BoxLayout.Y_AXIS);
		lPanel.setLayout(boxLayout);
		JLabel nameLabel = new JLabel("Prenumele Numele");
		clientNameTextField = new JTextField(15);
		clientNameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		lPanel.add(nameLabel);
		lPanel.add(clientNameTextField);
		JLabel emailLabel = new JLabel("@email");
		emailTextField = new JTextField(15);
		emailTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		lPanel.add(emailLabel);
		lPanel.add(emailTextField);
		JLabel kidsLabel = new JLabel("Is Kids");
		kidsTextField = new JTextField(15);
		kidsTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		lPanel.add(kidsLabel);
		lPanel.add(kidsTextField);
		JLabel phoneLabel = new JLabel("Phone number");
		phoneTextField = new JTextField(15);
		phoneTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		lPanel.add(phoneLabel);
		lPanel.add(phoneTextField);
		JLabel addressLabel = new JLabel("Address");
		addressTextField = new JTextField(15);
		addressTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		lPanel.add(addressLabel);
		lPanel.add(addressTextField);
		
		
		lPanel.setBackground(Color.orange);

		mainPanel.add(lPanel,BorderLayout.WEST);
		
	}

	private void addTopPanel() {
		JPanel tPanel = new JPanel();
		JButton fButton = new JButton("File");
		tPanel.add(fButton);
		JButton eButton = new JButton("Edit");
		tPanel.add(eButton);
		JButton hButton = new JButton("Help");
		tPanel.add(hButton);
		tPanel.setBackground(Color.red);

		mainPanel.add(tPanel,BorderLayout.NORTH);
	}

	private void addBottomPanel() {
		JPanel bPanel = new JPanel();
		bPanel.setBackground(Color.CYAN);
		mainPanel.add(bPanel, BorderLayout.SOUTH);

	}

}
