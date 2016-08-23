package md.convertit.bazaDeClienti.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.JsonFileService;
import md.convertit.bazaDeClienti.util.ClientFileUtil;

public class ClientTableModel extends AbstractTableModel{
	
	List<Client> clients = new ArrayList<>();

	String[] columnNames = { "ID", "Suriname", "Email", "Kids","Phone","Addres" };
    FileService fService;

public ClientTableModel(){
	
	super();
	fService = new JsonFileService();
	
	
	String path = ClientFileUtil.showOpenFileDialog();
	if (path == null)
		return;
	try {
		clients = fService.readAll(path);
	} catch (Exception e) {

		e.printStackTrace();
	}
	
}

	@Override
	public int getColumnCount() {
		
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		
		return clients.size();
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
		}
			else if (column == 4) {
				return client.getPhoneNumber();
			}
				
						else if (column ==5); {
							return client.getAddrees();
							
						}
						
				
			}
		
		
	
	}
	

