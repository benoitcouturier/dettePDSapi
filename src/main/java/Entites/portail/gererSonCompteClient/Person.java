package Entites.portail.gererSonCompteClient;

public class Person {
	private int Person_id;
	private String Person_name;
	private String Person_fistname;
	private String Person_login;
	private String Person_password;
	
	public Person(int person_id,String person_name, String person_fistname, String person_login, String person_password) {
		Person_id = person_id;
		Person_name = person_name;
		Person_fistname = person_fistname;
		Person_login = person_login;
		Person_password = person_password;
	}
	
	public int getPerson_id() {
		return Person_id;
	}

	public void setPerson_id(int person_id) {
		Person_id = person_id;
	}
	
	public String getPerson_name() {
		return Person_name;
	}
	public void setPerson_name(String person_name) {
		Person_name = person_name;
	}
	
	public String getPerson_fistname() {
		return Person_fistname;
	}
	public void setPerson_fistname(String person_fistname) {
		Person_fistname = person_fistname;
	}
	public String getPerson_login() {
		return Person_login;
	}
	public void setPerson_login(String person_login) {
		Person_login = person_login;
	}
	public String getPerson_password() {
		return Person_password;
	}
	public void setPerson_password(String person_password) {
		Person_password = person_password;
	}
	
}
