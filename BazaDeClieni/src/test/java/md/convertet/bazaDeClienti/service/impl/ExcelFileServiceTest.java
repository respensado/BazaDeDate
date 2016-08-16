package md.convertet.bazaDeClienti.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import md.convertet.bazaDeClienti.demo.service.impl.DemoData;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.ExcelFileService;

public class ExcelFileServiceTest {
 FileService fService = new ExcelFileService();
 
 final String path = "clients.xlsm";
 final int TOTAL_DEMO_CLIENTS = 10;

 @Before
 public void prepare() throws Exception {
	 List<Client> clList = DemoData.getDemoClients(TOTAL_DEMO_CLIENTS);
	 fService.saveAll(clList, path);
 }
 @Test
	public void saveAllTest() throws Exception {
		List<Client> clList = DemoData.getDemoClients(10);
		assertNotNull(clList);
		fService.saveAll(clList,  path);
 
 
 

}
 
 @Test
	public void readAllTest() throws Exception{
	
		List<Client>clList = fService.readAll(path);
		assertNotNull(clList);
		assertFalse(clList.isEmpty());
		assertEquals(TOTAL_DEMO_CLIENTS, clList.size());
 
}
}
