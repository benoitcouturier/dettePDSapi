package Entites;

public class Personne {

	private String name,firstname;
	private int age,PersonneId;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPersonneId() {
		return PersonneId;
	}

	public void setPersonneId(int personneId) {
		PersonneId = personneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Personne(String name, String firstname, int age, int personneId) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.age = age;
		PersonneId = personneId;
	}
	
	public Personne() {
		
	}
	
	
}
