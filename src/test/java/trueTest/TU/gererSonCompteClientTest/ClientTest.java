package trueTest.TU.gererSonCompteClientTest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import DAO.portail.gererSonCompteClient.NotifClientDAO;
import Entites.portail.gererSonCompteClient.Customer_account;
import RestGT.referentiels.client.ClientService;


public class ClientTest {

	@Test
	public void testRechercheTypeCategorieMagasin() {

		ClientService clientService = new ClientService();
		NotifClientDAO<Customer_account> dao = new ClientDAOStub();

		Customer_account customer = new Customer_account();
		customer.setCustomer_sex("Male");
		Response r = clientService.find(customer,dao);
		assertEquals(500,r.getStatus());
		
		customer = new Customer_account();
		customer.setCustomer_sex("autre");
		r = clientService.find(customer,dao);
		assertEquals(200,r.getStatus());

	}
}
