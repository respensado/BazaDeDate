package md.convertit.bazaDeClienti.services;

import java.util.List;

import md.convertit.bazaDeClienti.domain.Client;

public interface FileService {

	void saveAll(List<Client> clients, String path) throws Exception;

	List<Client> readAll(String path) throws Exception;

}
