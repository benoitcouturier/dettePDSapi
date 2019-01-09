package RestGT.referentiels.magasins;

import java.util.ArrayList;

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;

public class CallMagasinImpl implements CallMagasin {

	@Override
	public boolean existType(int id) {
		MagasinsDAO<Magasin> magasinDAO = new MagasinDAOImpl();
		return magasinDAO.existType(id);
	}

	
	@Override
	public ArrayList<Magasin> rechercheType(Magasin m) throws Exception{
		MagasinsDAO<Magasin> magasinDAO = new MagasinDAOImpl();
		return magasinDAO.rechercheType(m);
	}
	
	@Override
	public ArrayList<Magasin> rechercheNom(Magasin m) throws Exception {
		MagasinsDAO<Magasin> magasinDAO = new MagasinDAOImpl();
		return magasinDAO.rechercheNom(m);
	}
}
