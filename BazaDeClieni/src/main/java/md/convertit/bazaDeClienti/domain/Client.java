package md.convertit.bazaDeClienti.domain;

/**
 * This class represents a Clint object
 * 
 * @author User
 *
 */

public class Client {

	private long id;
	private String name;

	private String email;
	private boolean kids;
	private long phoneNumber;
	private String addrees;

	public Client() {
		super();
	}

	public Client(String name, boolean kids, String email, int phoneNumber, String addrees) {
		super();

		this.name = name;

		this.email = email;
		this.kids = kids;
		this.phoneNumber = phoneNumber;
		this.addrees = addrees;
	}



	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isKids() {
		return kids;
	}

	public void setKids(boolean kids) {
		this.kids = kids;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddrees() {
		return addrees;
	}

	public void setAddrees(String addrees) {
		this.addrees = addrees;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", kids=" + kids + ", phoneNumber="
				+ phoneNumber + ", addrees=" + addrees + "]";
	}

	
	
	
	// this text added by other user
}
