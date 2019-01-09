package RestGT.referentiels.magasins;

import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;

public interface CallMagasin {

	public boolean existType(int id);
	public ArrayList<Magasin> rechercheType(Magasin m);
	public ArrayList<Magasin> rechercheNom(Magasin m);
	
}
