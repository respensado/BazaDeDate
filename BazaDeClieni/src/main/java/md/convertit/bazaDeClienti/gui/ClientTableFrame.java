package md.convertit.bazaDeClienti.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.gui.model.SqlClientTableModel;
import md.convertit.bazaDeClienti.gui.table.ButtonRenderer;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.JsonFileService;
import md.convertit.bazaDeClienti.services.impl.XmlFileService;
import md.convertit.bazaDeClienti.util.ClientFileUtil;

public class ClientTableFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTextField idClientTextField;
	private JTextField clientNameTextField;
	private JTextField emailTextField;
	private JCheckBox kidsCheckBox;
	private JTextField phoneTextField;
	private JTextField addressTextField;
	private JButton saveButton;
	private JButton deleteButton;
	private JButton editButton;
	// private JButton deleteButoon;
	private JButton showButoon;
	private JButton exportJsonButton;
	private JButton exportXMLButton;
	private JButton exportExcelButton;
	private JTextField roomTextField;
	private JTextField areaTextField;
	private JTextField dateTextField;
	private JTextField priceTextField;
	private JButton addButton;
	private JButton startButton;
	private JButton pauseButton;
	private JButton finishButton;

	private JTable table;
	private FileService fService;
	protected boolean validFields;

	public ClientTableFrame() throws HeadlessException {
		super();
		setTitle("User Manager");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.gray);
		getContentPane().add(mainPanel);
		SqlClientTableModel clientTableModel = new SqlClientTableModel();
		table = new JTable(clientTableModel);

		JScrollPane sPane = new JScrollPane(table);

		mainPanel.add(sPane, BorderLayout.CENTER);
		table.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		table.getColumn("Task").setCellRenderer(new ButtonRenderer());
		// table.getColumn("Task").setCellEditor(
		// new ButtonEditor(new JCheckBox()));

		setMinimumSize(new Dimension(800, 300));
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
	}

	public void start() {

		addTopPanel();
		addBottomPanel();
		addLeftPanel();
		//addRightPanel();
		addActionListener();

		setVisible(true);

	}

	private void addActionListener() {

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					if (column == 6) {
						System.out.println("A fost apasat Task button de pe rindul " + row);
						int roww = table.getSelectedRow();
						SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();
						Client client = tableModel.getClient(roww);
						JOptionPane.showMessageDialog(null, client.getId());
					}
				}
			}
		});

		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean valid = vallidateFilds();
				if (valid) {
					System.out.println("valid");
					Client client = new Client();
					if (!idClientTextField.getText().isEmpty()) {
						client.setId(Long.valueOf(idClientTextField.getText().trim()));
					}
					client.setName(clientNameTextField.getText().trim());
					client.setEmail(emailTextField.getText().trim());
					client.setKids(kidsCheckBox.isSelected());
					client.setPhoneNumber(Long.valueOf(phoneTextField.getText().trim()));
					client.setAddrees(addressTextField.getText().trim());

					SqlClientTableModel clientTableModel = (SqlClientTableModel) table.getModel();
					clientTableModel.addClients(client);

					idClientTextField.setText("");
					clientNameTextField.setText("");
					emailTextField.setText("");
					kidsCheckBox.isSelected();
					phoneTextField.setText("");
					addressTextField.setText("");

				}

			}

		});

		editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row != -1) {
					SqlClientTableModel clientTableModel = (SqlClientTableModel) table.getModel();
					clientTableModel.getClient(row);
					Client client = clientTableModel.getClient(row);
					idClientTextField.setText(String.valueOf(client.getId()));
					clientNameTextField.setText(client.getName());
					emailTextField.setText(client.getEmail());
					kidsCheckBox.setSelected(client.isKids());
					phoneTextField.setText(String.valueOf(client.getPhoneNumber()));
					addressTextField.setText(client.getAddrees());

				} else {
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Please select a row from table!",
							"No selected row", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("blabla");
				int row = table.getSelectedRow();

				if (row != -1) {
					SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();

					Client client = tableModel.getClient(row);
					System.out.println(row);
					tableModel.removeClient(client.getId());

				} else {
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Please select a row from table!",
							"No selected row", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		showButoon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row != -1) {
					SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();
					tableModel.getClient(row);
					Client client = tableModel.getClient(row);
					JOptionPane.showMessageDialog(ClientTableFrame.this, client, "Selected user list: ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Please select a row from table!",
							"No selected row", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		exportJsonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();
				exportToJson(tableModel.getClient());

			}
		});
		exportXMLButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();
				exportToXML(tableModel.getClient());
			}

			private void exportToXML(List<Client> client) {
				fService = new XmlFileService();
				try {
					String path = ClientFileUtil.showSavenFileDialo();
					if (path == null)
						return;
					fService.saveAll(client, path.concat(".xml"));
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Users was successfully exported",
							"Export to XML", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Error on export to XML", "Export to XML",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();
				}
			}
		});
		exportExcelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SqlClientTableModel tableModel = (SqlClientTableModel) table.getModel();
				exportToExcel(tableModel.getClient());

			}

			private void exportToExcel(List<Client> client) {
				fService = new JsonFileService();
				try {
					String path = ClientFileUtil.showSavenFileDialo();
					if (path == null)
						return;
					fService.saveAll(client, path.concat(".xls"));
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Users was successfully exported",
							"Export to Excel", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(ClientTableFrame.this, "Error on export to  Excel", "Export to Excel",
							JOptionPane.ERROR_MESSAGE);

					e.printStackTrace();

				}
			}
		});

	}

	protected void exportToJson(List<Client> client) {
		fService = new JsonFileService();
		try {
			String path = ClientFileUtil.showSavenFileDialo();
			if (path == null)
				return;
			fService.saveAll(client, path.concat(".json"));
			JOptionPane.showMessageDialog(ClientTableFrame.this, "Users was successfully exported", "Export to JSON",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(ClientTableFrame.this, "Error on export to JSON", "Export to JSON",
					JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}
	}

	protected boolean vallidateFilds() {
		validFields = true;

		// validasre nume
		if (clientNameTextField.getText().isEmpty()) {
			validFields = false;
			JOptionPane.showMessageDialog(null, "Please enter your Name");
		}
		if (emailTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter your Email");
			validFields = false;

		}
		if (phoneTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter your Phone");
			validFields = false;

		}
		if (addressTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter your Address");
			validFields = false;

		}

		return validFields;
	}

	

	private void addLeftPanel() {
		JPanel lPanel = new JPanel();
		lPanel.setBorder(new TitledBorder(new EtchedBorder(), "Clienti"));
		BoxLayout boxLayout = new BoxLayout(lPanel, BoxLayout.Y_AXIS);
		lPanel.setLayout(boxLayout);
		// JLabel nameLabel = new JLabel("Prenumele Numele");

		idClientTextField = new JTextField(15);
		idClientTextField.setBorder(new TitledBorder(new EtchedBorder(), "id"));
		idClientTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		idClientTextField.setEditable(false);

		lPanel.add(idClientTextField);
		clientNameTextField = new JTextField(15);
		clientNameTextField.setBorder(new TitledBorder(new EtchedBorder(), "Numele Pronumele"));
		clientNameTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		// lPanel.add(nameLabel);
		lPanel.add(clientNameTextField);
		// JLabel emailLabel = new JLabel("@email");
		emailTextField = new JTextField(15);
		emailTextField.setBorder(new TitledBorder(new EtchedBorder(), "Email"));
		emailTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		// lPanel.add(emailLabel);
		lPanel.add(emailTextField);
		// JLabel kidsLabel = new JLabel("Is Kids");
		JPanel kidsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		kidsPanel.setBackground(Color.gray);
		kidsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		kidsCheckBox = new JCheckBox("Is Kids");
		kidsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Is Kids"));
		kidsPanel.add(kidsCheckBox);

		// kidsCheckBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		// lPanel.add(kidsLabel);
		lPanel.add(kidsPanel);
		// JLabel phoneLabel = new JLabel("Phone number");
		phoneTextField = new JTextField(15);
		phoneTextField.setBorder(new TitledBorder(new EtchedBorder(), "Phone Number"));

		phoneTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		// lPanel.add(phoneLabel);
		lPanel.add(phoneTextField);
		// JLabel addressLabel = new JLabel("Address");
		addressTextField = new JTextField(15);
		addressTextField.setBorder(new TitledBorder(new EtchedBorder(), "Address"));
		addressTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		// lPanel.add(addressLabel);
		lPanel.add(addressTextField);
		lPanel.setBackground(Color.CYAN);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setBackground(Color.darkGray);
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder()));
		saveButton = new JButton("Save");
		saveButton.setPreferredSize(new Dimension(55, 22));
		editButton = new JButton("Edit");
		editButton.setPreferredSize(new Dimension(55, 22));
		buttonPanel.add(editButton);

		buttonPanel.add(saveButton);
		deleteButton = new JButton("Delete");
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

		// deleteButoon = new JButton("Delete");
		showButoon = new JButton("Show");
		exportJsonButton = new JButton("Export to JSON");
		exportXMLButton = new JButton("Export to XML");
		exportExcelButton = new JButton("Export to Excel");

		// bPanel.add(deleteButoon);
		bPanel.add(showButoon);
		bPanel.add(exportJsonButton);
		bPanel.add(exportXMLButton);
		bPanel.add(exportExcelButton);
		mainPanel.add(bPanel, BorderLayout.SOUTH);

	}

}
