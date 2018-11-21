package RestGT;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.PersonneDAO;
import Entites.Personne;

@Path("/Dossier")
public class DossierApiRest {

	@GET
	@Path("/tous")
	@Produces("application/json")
	public Response get() {
		PersonneDAO personneDAO = new PersonneDAO();
		ArrayList<Personne> personne = personneDAO.getAllPersonnes();
		System.out.println(personne.size());
		ObjectMapper mapper = new ObjectMapper();
		String res = new String();
		try {
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personne);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(res).build();
	}

	
}
