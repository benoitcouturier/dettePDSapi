package Rest.referentiels.tarifsLivraison;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.tarifsLivraison.Withdrawal_methodDAO;
import Entites.referentiels.tarifsLivraison.Withdrawal_method;

@Path("/WM")
public class Withdrawalmethod_rest {
		
		@POST
		@Path("/add")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response postMethod(String method) {
			Withdrawal_methodDAO wmDAO = new Withdrawal_methodDAO();
			ObjectMapper mapper = new ObjectMapper();
			String response = new String();
			System.out.println("[CREATING A NEW WITHDRAWAL METHOD...]");
			try {
				Withdrawal_method wm = mapper.readValue(method, Withdrawal_method.class);
				wmDAO.create(wm); 
				response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wm);
			} catch (Exception e) {
				return Response.status(500).entity(e).build();
			}
			return Response.status(200).entity(response).build();
		}
		
		@GET
		@Path("/all")
		@Produces("application/json")
		public Response getAll() {
			Withdrawal_methodDAO wmDAO = new Withdrawal_methodDAO();
			ArrayList<Withdrawal_method> wm = wmDAO.read();
			System.out.println(wm.size());
			ObjectMapper mapper = new ObjectMapper();
			String res = new String();
			System.out.println("[FINDING ALL WITHDRAWAL METHODS...]");
			try {
				res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wm);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Response.status(200).entity(res).build();
		}
	}

