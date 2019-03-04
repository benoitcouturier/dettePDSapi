package RestGT.referentiels.produitsVendus;

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
import DAO.referentiels.produitsVendus.ProductTypeDAO;
import DAO.referentiels.produitsVendus.ProductTypeDAOImpl;
import Entites.referentiels.produitsVendus.ProductType;

@Path("/ProductType")
public class ProductTypeApiRest {

	private static final Logger log = Logger.getLogger(ProductTypeApiRest.class);

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
		ProductTypeDAO<ProductType> tDAO = new ProductTypeDAOImpl();
		ArrayList<ProductType> types = tDAO.read();
		ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(types);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
	
	@GET
	@Path("/find/{prodt_id}")
	@Produces("application/json")
	public Response get(@PathParam("prodt_id") int prodt_id) {
		init();
		log.info("ENTREE DANS LA METHODE GET EN GET");
		String res = new String();
		try {
		ProductTypeDAO<ProductType> tDAO = new ProductTypeDAOImpl();
		ProductType pt = new ProductType();
		pt.setProdt_id(prodt_id);
		ProductType types = tDAO.find(pt);
		ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(types);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
}
