package trueTest.TU.Magasins;

import java.util.ArrayList;

import Entites.referentiels.magasins.Magasin;
import RestGT.referentiels.magasins.CallMagasin;

public class CallMagasinStub implements CallMagasin {

	@Override
	public boolean existType(int id) {
		
		if(id<5) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Magasin> rechercheType(Magasin m)  throws Exception  {
		// TODO Auto-generated method stub
		if(m.getIdType()==9) {
			throw new Exception();
		}
		if(m.getIdType()>6) {
			ArrayList<Magasin> array = new ArrayList<Magasin>();
			array.add(new Magasin());
			return array;
		}
		return new ArrayList<Magasin>();
	}

	@Override
	public ArrayList<Magasin> rechercheNom(Magasin m) throws Exception {
		// TODO Auto-generated method stub
		if(m.getNom().equalsIgnoreCase("oui")) {
			ArrayList<Magasin> array = new ArrayList<Magasin>();
			array.add(new Magasin());
			return array;
		}
		if(m.getNom().equalsIgnoreCase("exception")) {
			throw new Exception();
		}
		return new ArrayList<Magasin>();
	}

}
