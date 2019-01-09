package Entites.portail.gererSonCompteClient;

public class NotifCustomer {

	 private String customer_sex;
	 private int customer_location;
	 private int customer_notification; 
	 private int id_customer;
	 
	public String getCustomer_sex() {
		return customer_sex;
	}
	public void setCustomer_sex(String customer_sex) {
		this.customer_sex = customer_sex;
	}
	public int getCustomer_location() {
		return customer_location;
	}
	public void setCustomer_location(int customer_location) {
		this.customer_location = customer_location;
	}
	public int getCustomer_notification() {
		return customer_notification;
	}
	public void setCustomer_notification(int customer_notification) {
		this.customer_notification = customer_notification;
	}
	
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}

}
