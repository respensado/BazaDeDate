package md.convertit.bazaDeClienti.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TaskClientFrame {
	private JFrame frameTask;
	private JPanel rPanel;
	private JTextField iidClientTextField;
	private void addRightPanel() {

		JPanel rPanel = new JPanel();
		rPanel.setBorder(new TitledBorder(new EtchedBorder(), "Tasks"));
		BoxLayout boxLayout = new BoxLayout(rPanel, BoxLayout.Y_AXIS);
		rPanel.setLayout(boxLayout);
//		idClientTextField = new JTextField(15);
//		idClientTextField.setBorder(new TitledBorder(new EtchedBorder(), "id"));
//		idClientTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
//		idClientTextField.setEditable(false);
//		rPanel.add(idClientTextField);
//
//		roomTextField = new JTextField(15);
//		roomTextField.setBorder(new TitledBorder(new EtchedBorder(), "Room"));
//		roomTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
//		rPanel.add(roomTextField);
//		areaTextField = new JTextField(15);
//		areaTextField.setBorder(new TitledBorder(new EtchedBorder(), "Area"));
//		areaTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
//		rPanel.add(areaTextField);
//		priceTextField = new JTextField(15);
//		priceTextField.setBorder(new TitledBorder(new EtchedBorder(), "Price"));
//		priceTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
//		rPanel.add(priceTextField);
//		JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		addButtonPanel.setBackground(Color.gray);
//		addButtonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
//		addButton = new JButton("Add");
//		addButton.setPreferredSize(new Dimension(55, 22));
//
//		addButtonPanel.add(addButton);
//		rPanel.add(addButtonPanel);
//		dateTextField = new JTextField(15);
//		dateTextField.setBorder(new TitledBorder(new EtchedBorder(), "Date/Time"));
//		dateTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
//		rPanel.add(dateTextField);
//		JPanel rButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		rButtonPanel.setBackground(Color.darkGray);
//		rButtonPanel.setBorder(new TitledBorder(new EtchedBorder()));
//		startButton = new JButton("Start");
//		startButton.setPreferredSize(new Dimension(55, 22));
//		rButtonPanel.add(startButton);
//		pauseButton = new JButton("Pause");
//		pauseButton.setPreferredSize(new Dimension(65, 22));
//		rButtonPanel.add(pauseButton);
//
//		finishButton = new JButton("Finish");
//		finishButton.setPreferredSize(new Dimension(75, 22));
//
//		rButtonPanel.add(finishButton);
//
//		rPanel.add(rButtonPanel);
//
//		rPanel.setBackground(Color.gray);
//
//		mainPanel.add(rPanel, BorderLayout.EAST);

	}

}
