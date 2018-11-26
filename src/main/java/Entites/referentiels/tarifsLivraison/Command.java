package Entites.referentiels.tarifsLivraison;

import java.io.Serializable;
import java.sql.Date;

public class Command implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int Command_id;
	private Date Command_date;
	private Command_state CommandS;
	private Customer Customer;
	private Withdrawal_method WM;
	
	public int getCommand_id() {
		return Command_id;
	}
	public void setCommand_id(int command_id) {
		Command_id = command_id;
	}
	public Date getCommand_date() {
		return Command_date;
	}
	public void setCommand_date(Date command_date) {
		Command_date = command_date;
	}
	public Command_state getCommandS() {
		return CommandS;
	}
	public void setCommandS(Command_state commandS) {
		CommandS = commandS;
	}
	public Customer getCustomer() {
		return Customer;
	}
	public void setCustomer(Customer customer) {
		Customer = customer;
	}
	public Withdrawal_method getWM() {
		return WM;
	}
	public void setWM(Withdrawal_method wM) {
		WM = wM;
	}
	public Command(Date command_date, Command_state commandS, Customer customer, Withdrawal_method wM) {
		super();
		Command_date = command_date;
		CommandS = commandS;
		Customer = customer;
		WM = wM;
	}
	public Command() {
	}
	
	

}
