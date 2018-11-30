package DAO.referentiels.magasins;

import DAO.CrudDAO;

public interface MagasinsDAO<T> extends CrudDAO<T>{


	public void creationUC() throws Exception;
	
}
