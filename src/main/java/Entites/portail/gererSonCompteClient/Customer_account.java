package Entites.portail.gererSonCompteClient;

import java.util.Map;

public class Customer_account {
 private Customer customer;
 private int Customer_phone;
 private int Age;
 private String Sex;
 private String State;
 private String city;
 private String adress;
 private String email;
 private Map<Integer,String> Customer_preferences;
 private int id_profil;
 private int id_command;
 private int id_customer;
 
 public Customer_account(Customer customer, int customer_phone, int age, String sex, String state, String city,
		String adress, String email, Map<Integer, String> customer_preferences, int id_profil, int id_command,
		int id_customer) {
	super();
	this.customer = customer;
	Customer_phone = customer_phone;
	Age = age;
	Sex = sex;
	State = state;
	this.city = city;
	this.adress = adress;
	this.email = email;
	Customer_preferences = customer_preferences;
	this.id_profil = id_profil;
	this.id_command = id_command;
	this.id_customer = id_customer;
}
 
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public int getCustomer_phone() {
	return Customer_phone;
}
public void setCustomer_phone(int customer_phone) {
	Customer_phone = customer_phone;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getSex() {
	return Sex;
}
public void setSex(String sex) {
	Sex = sex;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Map<Integer, String> getCustomer_preferences() {
	return Customer_preferences;
}
public void setCustomer_preferences(Map<Integer, String> customer_preferences) {
	Customer_preferences = customer_preferences;
}
public int getId_profil() {
	return id_profil;
}
public void setId_profil(int id_profil) {
	this.id_profil = id_profil;
}
public int getId_command() {
	return id_command;
}
public void setId_command(int id_command) {
	this.id_command = id_command;
}
public int getId_customer() {
	return id_customer;
}
public void setId_customer(int id_customer) {
	this.id_customer = id_customer;
}

 
}
