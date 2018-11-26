package Rest.referentiels.produitsVendus;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import DAO.referentiels.produitsVendus.*;
import Entites.referentiels.produitsVendus.*;

@Path("/Product")
public class ProductApiRest {

	@GET
	@Path("/tous")
	@Produces("application/json")
	public Response get() throws SQLException {
		ProductDAO pDAO = new ProductDAO();
		List<Product> p = pDAO.read();
		System.out.println(p.size());
		ObjectMapper mapper = new ObjectMapper();
		String res = new String();
		try {
			res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(res).build();
	}

	
}
