package RestGT.referentiels.client;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import DAO.portail.gererSonCompteClient.ClientAccountDAO;
import DAO.portail.gererSonCompteClient.ClientAccountDAOImpl;
import DAO.portail.gererSonCompteClient.NotifClientDAO;
import DAO.portail.gererSonCompteClient.NotifClientDAOImpl;
import DAO.referentiels.produitsVendus.ProductDAO;
import DAO.referentiels.produitsVendus.ProductDAOImpl;
import Entites.portail.gererSonCompteClient.Customer_account;
import Entites.referentiels.produitsVendus.Product;


@Path("/Client")
public class ClientApiRest {

	
	private static final Logger log = Logger.getLogger(ClientApiRest.class);

	public static void init() {
		if(log.getLevel() == null) {
			BasicConfigurator.configure();
			log.setLevel(Level.DEBUG);
		}
	}

	@GET
	@Path("/tous")
	@Produces("application/json")
	public Response get() {
		init();
		log.info("ENTREE DANS LA METHODE GET EN GET");
		return null;
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(String client) {
		
		log.info("ENTREE DANS LA METHODE ADD EN POST");
		System.out.println(client);
		ClientAccountDAO<Customer_account> cDAO = new ClientAccountDAOImpl();
		
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		System.out.println(client);
		try {
			Customer_account c = mapper.readValue(client, Customer_account.class); 
			cDAO.create(c);
			String res = "Client account saved :"; 
			log.info(res);
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).entity(response).build();
	}

	// à mdofier
	@GET
	@Path("/find/sex={sex}&location={location}&notification={notification}")
	@Produces("application/json")
	public Response find(@PathParam("sex") String customer_sex, @PathParam("location") int customer_location, @PathParam("notification") int customer_notification) {
		init();
		log.info("Début méthode Search en @GET");
		String res = new String();
		try {
		NotifClientDAO<Customer_account> cDAO = new NotifClientDAOImpl();
		Customer_account c = new Customer_account();
		c.setCustomer_sex(customer_sex);
		c.setCustomer_location(customer_location);
		c.setCustomer_notification(customer_notification);
		
		Customer_account ca = cDAO.find(c);
		ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ca);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}


}
