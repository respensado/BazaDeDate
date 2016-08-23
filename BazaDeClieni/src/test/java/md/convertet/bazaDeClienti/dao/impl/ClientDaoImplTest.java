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

	@Test
	public void testUpdate() {
		final Long USER_ID = 7L;
		Client clients = new Client();
		clients.setName("newtestName");
		clients.setKids(true);
		clients.setEmail("newe@email.com");
		clients.setPhoneNumber(9099999);
		clients.setAddrees("newadress");
	boolean result = cDao.update(clients, USER_ID);
	Assert.assertTrue(result);
	}
	@Test
	public void testDelete(){
		final Long USER_ID = 4L;
		boolean result = cDao.delete(USER_ID);
		Assert.assertTrue(result);
	}

}
