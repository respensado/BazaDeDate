package md.convertet.bazaDeClienti.service.impl;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import md.convertet.bazaDeClienti.demo.service.impl.DemoData;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;
import md.convertit.bazaDeClienti.services.impl.ExcelFileService;

public class ExcelFileServiceTest {
 FileService fService = new ExcelFileService();
 
 final String PATH = "clients.xls";
 final int TOTAL_DEMO_CLIENTS = 10;

 @Before
 public void prepare() throws Exception {
	 List<Client> clList = DemoData.getDemoClients(TOTAL_DEMO_CLIENTS);
	 fService.saveAll(clList, PATH);
 }
 @Test
	public void saveAllTest() throws Exception {
		List<Client> clList = DemoData.getDemoClients(10);
		assertNotNull(clList);
		fService.saveAll(clList,  PATH);
 
 
 

}
 
 @Test
	public void readAllTest() throws Exception{
	
		List<Client> clList = fService.readAll(PATH);
		
		assertNotNull(clList);
		assertFalse(clList.isEmpty());
		assertEquals(TOTAL_DEMO_CLIENTS, clList.size());
 
}
 
}