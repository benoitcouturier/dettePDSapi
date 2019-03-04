package DAO.referentiels.produitsVendus;

import java.util.ArrayList;
import DAO.CrudDAO;
import Entites.referentiels.magasins.Magasin;
import Entites.referentiels.produitsVendus.Product;

public interface ProductDAO<T> extends CrudDAO<T> {
	public ArrayList<Product> findtype(Product object) throws Exception;
	public ArrayList<Product> findname(Product object) throws Exception;
	public boolean issettype(int id) throws Exception;
}
