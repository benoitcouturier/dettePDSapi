package RestGT;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.PersonneDAO;
import Entites.Personne;

@Path("/Personne")
public class PersonneAPIRest {
	
	private static final Logger log = Logger.getLogger(PersonneAPIRest.class);
	
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
		PersonneDAO personneDAO = new PersonneDAO();
		ArrayList<Personne> personne = personneDAO.getAllPersonnes();
		ObjectMapper mapper = new ObjectMapper();
		String res = new String();
		try {
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personne);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(String personne) {
		log.info("ENTREE DANS LA METHODE ADD EN POST");
		PersonneDAO personneDAO = new PersonneDAO();
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		try {
			Personne p = mapper.readValue(personne, Personne.class);
			personneDAO.add(p);
			String res = "Personne saved :"+p.getFirstname()+" "+p.getName()+" "+p.getAge()+" "+p.getPersonneId(); 
			log.info(res);
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		
		return Response.status(200).entity(response).build();
	}


}
