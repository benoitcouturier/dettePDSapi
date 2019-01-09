package DAO.referentiels.produitsVendus;

import java.util.ArrayList;
import DAO.CrudDAO;
import Entites.referentiels.produitsVendus.Product;

public interface ProductDAO<T> extends CrudDAO<T> {

	public ArrayList<Product> findname(Product object) throws Exception;
}
