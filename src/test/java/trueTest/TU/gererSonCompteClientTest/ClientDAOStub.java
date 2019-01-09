package trueTest.TU.gererSonCompteClientTest;

import java.util.ArrayList;

import DAO.portail.gererSonCompteClient.ClientAccountDAO;
import DAO.portail.gererSonCompteClient.NotifClientDAO;
import Entites.portail.gererSonCompteClient.Customer;
import Entites.portail.gererSonCompteClient.Customer_account;

public class ClientDAOStub implements NotifClientDAO<Customer_account> {

	@Override
	public void create(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Customer_account> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer_account object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer_account object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer_account find(Customer_account object) throws Exception {
		if(object.getCustomer_sex().equalsIgnoreCase("Male")){
			throw new Exception();
		}
		return new Customer_account();
	}

	@Override
	public ArrayList<Customer_account> getEmplacementsDisponibles() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
