package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;

public class Customer implements Serializable{
private static final long serialVersionUID = 1L;
	
	private int Customer_id;

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public Customer(int customer_id) {
		super();
		Customer_id = customer_id;
	}

	public Customer() {
	}
	
	
}
