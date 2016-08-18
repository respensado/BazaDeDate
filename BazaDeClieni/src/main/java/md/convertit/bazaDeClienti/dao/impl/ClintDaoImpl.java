package md.convertit.bazaDeClienti.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import md.convertit.bazaDeClienti.dao.ClintDao;
import md.convertit.bazaDeClienti.domain.Client;

public class ClintDaoImpl implements ClintDao {

	Connection conn;
	PreparedStatement prStat;
	
	
	@Override
	public boolean save(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
