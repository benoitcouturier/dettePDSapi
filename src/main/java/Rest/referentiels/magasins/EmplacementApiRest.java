package Rest.referentiels.magasins;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.magasins.EmplacementDAO;
import DAO.referentiels.magasins.EmplacementDAOImpl;
import Entites.referentiels.magasins.Emplacement;

@Path("/Emplacement")
public class EmplacementApiRest {

	private static final Logger log = Logger.getLogger(EmplacementApiRest.class);

	public static void init() {
		if(log.getLevel() == null) {
			BasicConfigurator.configure();
			log.setLevel(Level.DEBUG);
		}
	}

	@GET
	@Path("/emplacementsDisponibles")
	@Produces("application/json")
	public Response get() {
		init();
		log.info("ENTREE DANS LA METHODE GET EN GET");
		String res = new String();
		try {
			EmplacementDAO<Emplacement> eDAO = new EmplacementDAOImpl();
			ArrayList<Emplacement> emp = eDAO.getEmplacementsDisponibles();
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}

	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") int id) {
		init();
		log.info("ENTREE DANS LA METHODE GET EN GET");
		String res = new String();
		try {
			Emplacement e = new Emplacement();
			e.setId(id);
			EmplacementDAO<Emplacement> eDAO = new EmplacementDAOImpl();
			Emplacement emp = eDAO.find(e);
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
}
