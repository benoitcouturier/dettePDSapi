package DAO.referentiels.magasins;

import DAO.CrudDAO;
import Entites.referentiels.magasins.Magasin;

public interface MagasinsDAO<T> extends CrudDAO<T>{

	public Magasin selectMax() throws Exception;
}
