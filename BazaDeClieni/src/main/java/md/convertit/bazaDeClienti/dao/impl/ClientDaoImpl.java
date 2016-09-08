package md.convertit.bazaDeClienti.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mysql.fabric.xmlrpc.base.Array;

import md.convertet.bazaDeClienti.dao.impl.ClientDaoImplTest;
import md.convertit.bazaDeClienti.dao.ClientDao;
import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.util.ClientConnectionUtil;

public class ClientDaoImpl implements ClientDao {
	private static final Logger log = Logger.getLogger(ClientDaoImpl.class.getName());

	Connection conn;
	PreparedStatement prStat;

	@Override
	public boolean save(Client client) {
		try {
			conn = ClientConnectionUtil.getConnection();
			String sql = "INSERT INTO `clients` (`name`, `email`, `kids`,`phonenumber`,`address`  ) VALUES (?, ?, ?,?,?);";
			prStat = conn.prepareStatement(sql);
			prStat.setLong(1, client.getId());
			prStat.setString(2, client.getName());
			prStat.setString(3, client.getEmail());
			prStat.setBoolean(4, client.isKids());
			prStat.setLong(5, client.getPhoneNumber());
			prStat.setString(6, client.getAddrees());

			int affectedRows = prStat.executeUpdate();
			log.info(String.format("Saved object, total affected rows: %d", affectedRows));
			return true;
		} catch (SQLException e) {

			log.severe(String.format("Exception: %s", e.getMessage()));

		}
		return false;
	}

	@Override
	public List<Client> findAll() {

		List<Client> cList = new ArrayList<>();
		try {
			conn = ClientConnectionUtil.getConnection();

			String sql = "SELECT * FROM  `clients`";

			prStat = conn.prepareStatement(sql);
			ResultSet set = prStat.executeQuery();
			while (set.next()) {
				long id = set.getInt("id");

				String name = set.getString("name");
				String email = set.getString("email");
				boolean kids = set.getBoolean("kids");

				int phone = (int) set.getLong("phonenumber");
				String address = set.getString("address");

				Client client = new Client();

				client.setId(id);
				client.setName(name);
				client.setKids(kids);
				client.setEmail(email);
				client.setPhoneNumber(phone);
				client.setAddrees(address);
				cList.add(client);
				log.info(String.format("Added new client to list: %s", client.toString()));

			}
		} catch (SQLException e) {

			log.severe(String.format("Fatal error: %s", e.getMessage()));

		}
		log.info(String.format("Retrieved from database %d client", cList.size()));

		return cList;

	}

	@Override
	public boolean update(Client client, Long id) {
		try {
			conn = ClientConnectionUtil.getConnection();
			String sql = "INSERT INTO `clients` (`name`, `email`, `kids`,`phonenumber`,`address`  ) VALUES (?, ?, ?,?,?);";
			prStat = conn.prepareStatement(sql);
			prStat.setLong(1, client.getId());
			prStat.setString(2, client.getName());
			prStat.setString(3, client.getEmail());
			prStat.setBoolean(4, client.isKids());
			prStat.setLong(5, client.getPhoneNumber());
			prStat.setString(6, client.getAddrees());

			int affectedRows = prStat.executeUpdate();
			log.info(String.format("Update object, total affected rows: %d", affectedRows));
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.severe(String.format("Exception: %s", e.getMessage()));

		}
		return false;
	}

	@Override
	public boolean delete(Long id) {

		try {

			conn = ClientConnectionUtil.getConnection();
			String sql = "DELETE FROM `clients` WHERE `id`=? ;";

			prStat = conn.prepareStatement(sql);
			prStat.setLong(1, id);
			prStat.executeUpdate();

			log.info(String.format("Object with id: %d was deleted", id));
			return true;

		} catch (SQLException e) {

			log.severe(String.format("Exception: %s", e.getMessage()));
			e.printStackTrace();
		}
		return false;
	}

}
