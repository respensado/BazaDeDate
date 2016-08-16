package md.convertit.bazaDeClienti.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ClientXmlHelper {
	private List<Client> clientsList;
	
	public List<Client>getClientList(){
		return clientsList;
	}
	
	@XmlElement
	
	public void setClientList(List<Client> clientsList){
		this.clientsList = clientsList;
	}

}
