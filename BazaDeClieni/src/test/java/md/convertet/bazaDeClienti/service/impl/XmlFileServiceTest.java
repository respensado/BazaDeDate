package md.convertet.bazaDeClienti.service.impl;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;

import md.convertet.bazaDeClienti.demo.service.impl.DemoData;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.XmlFileService;

public class XmlFileServiceTest {
	FileService fileService = new XmlFileService();
	
	final String PATH = "clients.xml";
	final int TOTAL_DEMO_CLIENTS = 10;
	
	@Before
	
	public void prepare() throws Exception{
		List<Client> clientsList = DemoData.getDemoClients(TOTAL_DEMO_CLIENTS);
		fileService.saveAll(clientsList, PATH);
		
	}
	@Test
	public void saveAllTest() throws Exception{
		List<Client> clientsList = DemoData.getDemoClients(10);
				assertNotNull(clientsList);
		fileService.saveAll(clientsList, PATH);
	}
@Test
public void readAllTest() throws Exception{
	List<Client> clientsList = fileService.readAll(PATH);
	assertNotNull(clientsList);
	assertFalse(clientsList.isEmpty());
	assertEquals(TOTAL_DEMO_CLIENTS, clientsList.size());
	
}
@Test
public void dateTest(){
	System.out.println(new Date());
	System.out.println(new Date().getTime());
	
}

}
