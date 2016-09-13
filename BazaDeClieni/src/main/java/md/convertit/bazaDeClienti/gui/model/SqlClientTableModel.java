package md.convertit.bazaDeClienti.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import md.convertit.bazaDeClienti.dao.impl.ClientDaoImpl;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.JsonFileService;
import md.convertit.bazaDeClienti.util.ClientFileUtil;

public class SqlClientTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	ClientDaoImpl clientDao = new ClientDaoImpl();

	private List<Client> clients = new ArrayList<>();

	private String[] columnNames = { "ID", "Suriname", "Email", "Is Kids", "Phone Number", "Addres", "Task" };

	public List<Client> getClient() {
		return clients;
	}

	public SqlClientTableModel() {
		super();
		clients = clientDao.findAll();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return (int) clients.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Client client = clients.get(row);
		if (column == 0) {
			return client.getId();
		} else if (column == 1) {
			return client.getName();

		} else if (column == 2) {
			return client.getEmail();
		} else if (column == 3) {
			return client.isKids();
		} else if (column == 4) {
			return client.getPhoneNumber();

		} else if (column == 5) {
			return client.getAddrees();
		} else if (column ==6) {
			return "Task";
		}

		return clients;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

 public void addClients(Client client) {
	 if(client.getId()==0){
		 clientDao.save(client);
	 } else {
		 clientDao.update(client);
	 }

 clients = clientDao.findAll();

 fireTableDataChanged();

 }

 public void removeClient(long clientId) {
//	 System.out.println(row);

 clientDao.delete(clientId);

 clients = clientDao.findAll();

 fireTableDataChanged();

 }

 public Client getClient(int row) {
 return clients.get(row);
 }
 }

