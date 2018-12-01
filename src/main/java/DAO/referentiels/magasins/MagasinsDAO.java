package DAO.referentiels.magasins;

import java.util.ArrayList;

import DAO.CrudDAO;
import Entites.referentiels.magasins.Magasin;

public interface MagasinsDAO<T> extends CrudDAO<T>{

	public Magasin selectMax() throws Exception;
	public ArrayList<Magasin> rechercheType(Magasin object) throws Exception;
}
