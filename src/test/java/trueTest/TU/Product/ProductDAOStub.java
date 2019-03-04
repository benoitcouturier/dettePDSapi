package trueTest.TU.Product;

import java.util.ArrayList;

import DAO.referentiels.produitsVendus.ProductDAO;
import Entites.referentiels.produitsVendus.Product;

public class ProductDAOStub implements ProductDAO<Product> {


	@Override
	public ArrayList<Product> findname(Product p) throws Exception {
		// TODO Auto-generated method stub
		if(p.getPname().equalsIgnoreCase("oui")) {
			ArrayList<Product> liste = new ArrayList<Product>();
			liste.add(new Product());
			return liste;
		}
		if(p.getPname().equalsIgnoreCase("exception")) {
			throw new Exception();
		}
		return new ArrayList<Product>();
	}

	@Override
	public void create(Product object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Product object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product find(Product object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> findtype(Product object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean issettype(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



}
