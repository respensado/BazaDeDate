package md.convertit.bazaDeClienti.domain;

public class Client {

	private long id;
	private String name;
	private boolean kids;
	private String email;
	private int phoneNumber;
	private String addrees;

	public Client() {
		super();
	}

	public Client(String name, boolean kids, String email, int phoneNumber, String addrees) {
		super();

		this.name = name;
		this.kids = kids;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addrees = addrees;
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
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
		return "Client [id=" + id + ", name=" + name + ", kids=" + kids + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", addrees=" + addrees + "]";
	}

	
	}

