package RestGT.referentiels.magasins;

import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;

public interface CallMagasin {

	public boolean existType(int id);
	public ArrayList<Magasin> rechercheType(Magasin m) throws Exception;
	public ArrayList<Magasin> rechercheNom(Magasin m) throws Exception;
	
}
