package RestGT.referentiels.magasins;
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

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;


@Path("/Magasin")
public class MagasinApiRest {


	private static final Logger log = Logger.getLogger(MagasinApiRest.class);

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
		MagasinsDAO<Magasin> mDAO = new MagasinDAOImpl();
		ArrayList<Magasin> mag = mDAO.read();
		ObjectMapper mapper = new ObjectMapper();
		
		mDAO.creationUC();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(String mag) {
		log.info("ENTREE DANS LA METHODE ADD EN POST");
		MagasinsDAO<Magasin> mDAO = new MagasinDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		try {
			Magasin p = mapper.readValue(mag, Magasin.class);
			mDAO.create(p);
			String res = "Magsin saved :"+p.getNom()+" "+p.getDescription()+" "+p.getIdEmplacement()+" "+p.getIdType(); 
			log.info(res);
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}

		return Response.status(200).entity(response).build();
	}


}


