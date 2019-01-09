package RestGT.referentiels.client;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.portail.gererSonCompteClient.NotifClientDAO;
import Entites.portail.gererSonCompteClient.Customer_account;

public class ClientService {

	public Response find(Customer_account c, NotifClientDAO<Customer_account> dao) {
		try {
			Customer_account ca = dao.find(c);
			ObjectMapper mapper = new ObjectMapper();
			return Response.status(200).entity(ca).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return Response.status(500).build();
		}
	}	
}
