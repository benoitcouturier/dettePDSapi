package RestGT.referentiels.produitsVendus;

import java.util.ArrayList;

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

import DAO.referentiels.produitsVendus.ProductDAOImpl;
import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import DAO.referentiels.produitsVendus.ProductDAO;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.produitsVendus.Product;

@Path("/Product")
public class ProductApiRest {

	private static final Logger log = Logger.getLogger(ProductApiRest.class);

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
		log.info("test 1");
		String res = new String();
		try {
			ProductDAO<Product> pDAO = new ProductDAOImpl();
			ArrayList<Product> p = pDAO.read();
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(String p) {
		log.info("test 2");
		ProductDAO<Product> pDAO = new ProductDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		System.out.println("ok");
		try {
			Product prod = mapper.readValue(p, Product.class);
			pDAO.create(prod);
			String res = "Le produit ajouté est :"+prod.getPname()+" "+prod.getPrice()+" "+prod.getPqte()+" "+prod.getSid()+" "+prod.getPsid()+" "+prod.getPtid(); 
			log.info(res);
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).entity(response).build();
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(String p) {
		log.info("test 3");
		ProductDAO<Product> pDAO = new ProductDAOImpl();
		ObjectMapper mapper = new ObjectMapper();
		String response = new String();
		System.out.println("ok");
		try {
			Product prod = mapper.readValue(p, Product.class);
			pDAO.delete(prod);
			String res = "Le produit supprimé est :"+prod.getPid(); 
			log.info(res);
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return Response.status(500).entity(e).build();
		}

		return Response.status(200).entity(response).build();
	}
	
	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public Response find(@PathParam("id") int id) {
		init();
		log.info("test 4");
		String res = new String();
		try {
		ProductDAO<Product> pDAO = new ProductDAOImpl();
		Product p = new Product();
		p.setPid(id);
		Product pro = pDAO.find(p);
		ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e.getStackTrace());
		}
		return Response.status(200).entity(res).build();
	}

}
