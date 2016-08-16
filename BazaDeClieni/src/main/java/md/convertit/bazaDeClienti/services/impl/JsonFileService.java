package md.convertit.bazaDeClienti.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.services.FileService;

public class JsonFileService implements FileService {
	private static final Logger log = Logger.getLogger(JsonFileService.class.getName());
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private File file;

	public void saveAll(List<Client> clients, String path) throws Exception {
		 System.out.println("apelam salvarea aici");
		file = new File(path);
		FileWriter fileWriter = new FileWriter(file);
		gson.toJson(clients, fileWriter);
		fileWriter.close();
log.log(Level.INFO, "objects saved to: " + file.getAbsolutePath());

		
		
		
		
	}

	public List<Client> readAll(String path) throws Exception {
		file = new File(path);
		FileReader frClients = new FileReader(file);
		Type type = new TypeToken<List<Client>>(){}.getType();
		List<Client> clients =gson.fromJson(frClients, type);
	
		log.log(Level.INFO, String.format("Loaded from file %s total %d objects", file.getAbsolutePath(), clients.size()));
		
		return clients;
	}

	//public List<Client> readAll(String path) throws Exception {
	// null;
	}

