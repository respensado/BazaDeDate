package md.convertit.bazaDeClienti.dao;

import java.util.List;


import md.convertit.bazaDeClienti.domain.Client;

public interface ClientDao {

		boolean save(Client client);
		
		/**
		 * 
		 * @returna a list of {@link User} from database
		 */
		List<Client> findAll();
		//boolean update(Client client, Long id);
		
	//	boolean delete(Long id);
		
	//	long count();
	}



