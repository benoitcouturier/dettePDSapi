package Entites.portail.gererSonCompteClient;

public class Customer extends Person{
	
	private int Customer_id;

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public Customer(int person_id, String person_name, String person_fistname, String person_login,
			String person_password, int customer_id) {
		super(person_id, person_name, person_fistname, person_login, person_password);
		Customer_id = customer_id;
	}

	

}
