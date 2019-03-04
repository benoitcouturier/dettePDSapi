package RestGT.referentiels.produitsVendus;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.produitsVendus.ProductDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import DAO.referentiels.produitsVendus.ProductDAO;
import Entites.referentiels.produitsVendus.Product;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.magasins.RechercheVide;
import Entites.referentiels.produitsVendus.Error;


public class ProductService {

	
	public Response findproducttype(int prodt_id,ProductDAO<Product> dao) {
		try {
			String res = new String();
			if(!dao.issettype(prodt_id)) {
				return Response.status(202).entity("existe pas dans la base").build();
			}

			Product p = new Product();
			p.setPtid(prodt_id);
			ArrayList<Product> prod = dao.findtype(p);
			if(prod.isEmpty()) {
				Error erreur = new Error();
				erreur.setPname("aucun resultat");
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

	public Response findproductname(String product_name, ProductDAO<Product> dao) {
		try {
			String res = new String();
			Product p = new Product();
			if(!this.inputcontrol(product_name)){
				Error erreur = new Error();
				erreur.setPname("Caractere interdit");
				return Response.status(501).entity(erreur).build();
			}

			p.setPname(product_name);
			ArrayList<Product> prod = dao.findname(p);
			if(prod.isEmpty()) {
				Error erreur = new Error();
				erreur.setPname("aucun rsultat");
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
	
	public boolean inputcontrol(String product_name){
		String erreur="&'(-_)=~#{[|`\\^@]}%$*<>\"!:/.?,;";
		for (int i=0;i>erreur.length();i++){
			String input =""+erreur.charAt(i);
			if (product_name.contains(input)){
				return false;
			}
		}
		return true;
	}
}
