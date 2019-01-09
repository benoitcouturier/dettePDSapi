package RestGT.referentiels.produitsVendus;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.produitsVendus.ProductDAOImpl;
import DAO.referentiels.produitsVendus.ProductDAO;
import Entites.referentiels.produitsVendus.Product;
import Entites.referentiels.produitsVendus.Error;


public class ProductService {

	
	public Response FindProductName(String nom, ProductDAO<Product> dao) {
		try {
			String res = new String();
			Product p = new Product();
			p.setPname(nom);
			ArrayList<Product> prod = dao.findname(p);
			if(prod.isEmpty()) {
				Error erreur = new Error();
				erreur.setNom("Aucun résultat");
				return Response.status(201).entity(erreur).build();
			}
			ObjectMapper mapper = new ObjectMapper();
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(prod);
			return Response.status(200).entity(res).build();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return Response.status(500).entity(e).build();
		}
		
		
	}
}
