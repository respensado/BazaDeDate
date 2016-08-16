package md.convertet.bazaDeClienti.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import md.convertit.bazaDeClienti.domain.Client;

public class DemoData {

	public static List<Client> getDemoClients(int totalObjects) {
		List<Client> liClients = new ArrayList<Client>();
		Random rand = new Random(); 
		
		for (int i = 0; i < totalObjects; i++) {

			Client clients = new Client();
			clients.setName("name suriname: " + rand.nextInt(100));
			clients.setKids(i % 2 == 0);
			clients.setEmail("contact@mail.com");
			clients.setPhoneNumber(rand.nextInt(100));
			clients.setAddrees("addrees");

			liClients.add(clients);

		}
		return liClients;
	}

}
