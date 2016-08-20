package md.convertet.bazaDeClienti.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import md.convertit.bazaDeClienti.dao.ClientDao;
import md.convertit.bazaDeClienti.dao.impl.ClientDaoImpl;
import md.convertit.bazaDeClienti.domain.Client;

public class ClientDaoImplTest {
	
	private ClientDao cDao = new ClientDaoImpl();
	
	@Test
	
	public void testSave(){
		Client clients = new Client();
		clients.setName("testName");
		clients.setKids(true);
		clients.setEmail("e@email.com");
		clients.setPhoneNumber(999999);
		clients.setAddrees("adress");
		boolean result = cDao.save(clients);
		Assert.assertTrue(result);
		
	}
	@Test
	
	public void testFindAll(){
	List<Client> allClient = cDao.findAll();
	Assert.assertNotNull(allClient);
	Assert.assertFalse(allClient.isEmpty());
	Assert.assertTrue(allClient.size()>0);
	}
	

}
