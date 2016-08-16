package md.convertit.bazaDeClienti.services.impl;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import md.convertit.bazaDeClienti.domain.Client;
import md.convertit.bazaDeClienti.domain.ClientXmlHelper;
import md.convertit.bazaDeClienti.services.FileService;

public class XmlFileService implements FileService {

	private static final Logger log = Logger.getLogger(XmlFileService.class.getName());
	private File file;

	public void saveAll(List<Client> clients, String path) throws Exception {
		file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(ClientXmlHelper.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		ClientXmlHelper helper = new ClientXmlHelper();
		helper.setClientList(clients);
		marshaller.marshal(helper, file);
		log.log(Level.INFO, String.format("saved objects in file: %s", file.getAbsolutePath()));

	}

	public List<Client> readAll(String path) throws Exception {
		file = new File(path);
JAXBContext jaxbContext = JAXBContext.newInstance(ClientXmlHelper.class);
Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
ClientXmlHelper helper = (ClientXmlHelper) unmarshaller.unmarshal(file);
log.log(Level.INFO, String.format("Return total of %d objects from %s", helper.getClientList().size(), file.getAbsolutePath()));

		
		
		
		return helper.getClientList();
	}

}
