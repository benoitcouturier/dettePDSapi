package Rest.referentiels.tarifsLivraison;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.tarifsLivraison.Withdrawal_priceDAO;
import Entites.referentiels.tarifsLivraison.Withdrawal_price;

@Path("/WP")
public class Withdrawalprice_rest {

		@GET
		@Path("/all")
		@Produces("application/json")
		public Response getAll() {
			Withdrawal_priceDAO wpDAO = new Withdrawal_priceDAO();
			ArrayList<Withdrawal_price> wp = wpDAO.read();
			System.out.println(wp.size());
			ObjectMapper mapper = new ObjectMapper();
			String res = new String();
			try {
				res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Response.status(200).entity(res).build();
		}
	}

