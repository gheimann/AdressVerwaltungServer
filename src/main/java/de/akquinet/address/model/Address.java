
package de.akquinet.address.model;


public class Address {

	
	public Address() {
		// muss wegen json immer vorhanden sein 
	}

	public Address(Long id, Anreden anrede, String vorname, String nachname, String email) {
		this(anrede, vorname, nachname, email);
		this.id = id;
	}
	
	public Address(Anreden anrede, String vorname, String nachname, String email) {
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}

	private long id;
	
	private Anreden anrede;
	
	private String vorname;
	
	private String nachname;
	private String email;
	

	public Anreden getAnrede() {
		return anrede;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnrede(Anreden anrede) {
		this.anrede = anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		if (id != 0) {
			return (int) id;
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anrede == null) ? 0 : anrede.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != 0) {
			return id == other.id;
		}
		if (anrede != other.anrede)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Address [id=" + id + ", anrede=" + anrede + ", vorname=" + vorname + ", nachname=" + nachname + ", email=" + email
//				 + "]";
//	}

}
