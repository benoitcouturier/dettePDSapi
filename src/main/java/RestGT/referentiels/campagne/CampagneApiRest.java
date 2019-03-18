package RestGT.referentiels.campagne;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.campagne.CampagneDAOImpl;
import DAO.referentiels.campagne.CampagneDAO;
import Entites.referentiels.campagne.Campaign;


@Path("/Campagne")
public class CampagneApiRest {

	private static final Logger log = Logger.getLogger(CampagneApiRest.class);

	public static void init() {
		if (log.getLevel() == null) {
			BasicConfigurator.configure();
			log.setLevel(Level.DEBUG);
		}
	}

	@GET
	@Path("/tous")
	@Produces("application/json")
	public Response get() {
		init();
		log.info("Récupération de toutes les campagnes");
		String res = new String();
		try {
			CampagneDAO<Campaign> campagneDAO = new CampagneDAOImpl();
			ArrayList<Campaign> listCampaign = campagneDAO.read();
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listCampaign);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(res).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(String c) {
		log.info("Création d'une campagne");
		CampagneDAO<Campaign> campagneDAO = new CampagneDAOImpl();
		CampagneAlgorithme algo = new CampagneAlgorithme();          /** Algorithme **/
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		try {
			Campaign campagne = mapper.readValue(c, Campaign.class);
			algo.CampagneTraitement(campagne);
			campagneDAO.create(campagne);
			String res = "Nouvelle campagne créée : "+campagne.getIdCampaign()+" "+campagne.getNameCampaign(); 
			log.info(res); 
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).entity(response).build();
	}
}