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
	public ArrayList<Magasin> rechercheType(Magasin m) {
		MagasinsDAO<Magasin> magasinDAO = new MagasinDAOImpl();
		return magasinDAO.rechercheType(m);
	}
	 
}
