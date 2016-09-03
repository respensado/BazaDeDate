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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
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

		rPanel.setBackground(Color.darkGray);

		mainPanel.add(rPanel, BorderLayout.EAST);

	}

	private void addLeftPanel() {
		JPanel lPanel = new JPanel();
		lPanel.setBorder(new TitledBorder(new EtchedBorder(), "Clienti"));
		BoxLayout boxLayout = new BoxLayout(lPanel, BoxLayout.Y_AXIS);
		lPanel.setLayout(boxLayout);
		//JLabel nameLabel = new JLabel("Prenumele Numele");
		clientNameTextField = new JTextField(15);
		clientNameTextField.setBorder(new TitledBorder(new EtchedBorder(), "Numele Pronumele"));
		clientNameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		//lPanel.add(nameLabel);
		lPanel.add(clientNameTextField);
		//JLabel emailLabel = new JLabel("@email");
		emailTextField = new JTextField(15);
		emailTextField.setBorder(new TitledBorder(new EtchedBorder(), "Email"));
		emailTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		//lPanel.add(emailLabel);
		lPanel.add(emailTextField);
		//JLabel kidsLabel = new JLabel("Is Kids");
		kidsTextField = new JTextField(15);
		kidsTextField.setBorder(new TitledBorder(new EtchedBorder(), "Is Kids"));
		
		kidsTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		//lPanel.add(kidsLabel);
		lPanel.add(kidsTextField);
		//JLabel phoneLabel = new JLabel("Phone number");
		phoneTextField = new JTextField(15);
		phoneTextField.setBorder(new TitledBorder(new EtchedBorder(), "Phone Number"));
	
		phoneTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		//lPanel.add(phoneLabel);
		lPanel.add(phoneTextField);
		//JLabel addressLabel = new JLabel("Address");
		addressTextField = new JTextField(15);
		addressTextField.setBorder(new TitledBorder(new EtchedBorder(), "Address"));
		addressTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		//lPanel.add(addressLabel);
		lPanel.add(addressTextField);
		lPanel.setBackground(Color.CYAN);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setBackground(Color.darkGray);
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		
		JButton editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(55, 22));
		buttonPanel.add(editButton);
		JButton saveButton = new JButton("Save");
		saveButton.setPreferredSize(new Dimension(55, 22));
		buttonPanel.add(saveButton);
		JButton deleteButton = new JButton("Delete");
		deleteButton.setPreferredSize(new Dimension(75, 22));
		buttonPanel.add(deleteButton);

        lPanel.add(buttonPanel);
		lPanel.setBackground(Color.gray);

		mainPanel.add(lPanel, BorderLayout.WEST);

	}

	private void addTopPanel() {
		JPanel tPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton fButton = new JButton("File");
		fButton.setPreferredSize(new Dimension(55, 22));
		tPanel.add(fButton);
		JButton eButton = new JButton("Edit");
		eButton.setPreferredSize(new Dimension(55, 22));
		tPanel.add(eButton);
		JButton hButton = new JButton("Help");
		hButton.setPreferredSize(new Dimension(65, 22));
		tPanel.add(hButton);
		tPanel.setBackground(Color.lightGray);

		mainPanel.add(tPanel, BorderLayout.NORTH);
	}

	private void addBottomPanel() {
		JPanel bPanel = new JPanel();
		
		mainPanel.add(bPanel, BorderLayout.SOUTH);

	}

}
