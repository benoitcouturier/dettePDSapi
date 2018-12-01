package RestGT.referentiels.magasins;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import DAO.referentiels.magasins.TypeMagasinDAO;
import DAO.referentiels.magasins.TypeMagasinDAOImpl;
import Entites.referentiels.magasins.TypeMagasin;

@Path("/TypeMagasin")
public class TypeMagasinApiRest {

	private static final Logger log = Logger.getLogger(TypeMagasinApiRest.class);

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
		String res = new String();
		try {
		TypeMagasinDAO<TypeMagasin> tDAO = new TypeMagasinDAOImpl();
		ArrayList<TypeMagasin> types = tDAO.read();
		ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(types);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
}
