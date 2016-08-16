package md.convertet.bazaDeClienti.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import md.convertet.bazaDeClienti.demo.service.impl.DemoData;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.JsonFileService;

public class JsonFileServiceTest {
	
	FileService fs = new JsonFileService();
	final String PATH = "clients.txt";
	final int TOTAL_DEMO_CLIENTS = 10;
	
	
	
	@Test 
	
	public void saveAllTest() throws Exception{
		List<Client> clientsList = DemoData.getDemoClients(TOTAL_DEMO_CLIENTS);
		assertNotNull(clientsList);
		fs.saveAll(clientsList, PATH);
	}
	@Test
	
	public void readAllTest() throws Exception{
		List<Client> clientsList = fs.readAll(PATH);
		assertNotNull(clientsList);
		assertFalse(clientsList.isEmpty());
		assertEquals(TOTAL_DEMO_CLIENTS, clientsList.size());
	}
	
	
	

}
